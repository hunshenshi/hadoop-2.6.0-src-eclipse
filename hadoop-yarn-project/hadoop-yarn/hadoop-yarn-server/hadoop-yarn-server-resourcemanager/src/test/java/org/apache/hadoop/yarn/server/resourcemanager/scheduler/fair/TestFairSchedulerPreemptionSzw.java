/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.yarn.server.resourcemanager.scheduler.fair;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.yarn.api.records.ApplicationAttemptId;
import org.apache.hadoop.yarn.api.records.Resource;
import org.apache.hadoop.yarn.conf.YarnConfiguration;
import org.apache.hadoop.yarn.server.resourcemanager.MockNodes;
import org.apache.hadoop.yarn.server.resourcemanager.MockRM;
import org.apache.hadoop.yarn.server.resourcemanager.resource.ResourceType;
import org.apache.hadoop.yarn.server.resourcemanager.rmnode.RMNode;
import org.apache.hadoop.yarn.server.resourcemanager.scheduler.ResourceScheduler;
import org.apache.hadoop.yarn.server.resourcemanager.scheduler.event.NodeAddedSchedulerEvent;
import org.apache.hadoop.yarn.server.resourcemanager.scheduler.event.NodeUpdateSchedulerEvent;
import org.apache.hadoop.yarn.util.resource.Resources;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestFairSchedulerPreemptionSzw extends FairSchedulerTestBase {
  private final static String ALLOC_FILE = new File("F:\\test-queues").getAbsolutePath();

  private MockClock clock;


  @Override
  protected Configuration createConfiguration() {
    Configuration conf = super.createConfiguration();
    conf.setClass(YarnConfiguration.RM_SCHEDULER, FairScheduler.class,
        ResourceScheduler.class);
    // 开启抢占开关
    conf.setBoolean(FairSchedulerConfiguration.PREEMPTION, true);
    // fair配置所在路径
    conf.set(FairSchedulerConfiguration.ALLOCATION_FILE, ALLOC_FILE);
    return conf;
  }

  @Before
  public void setup() throws IOException {
    conf = createConfiguration();
    clock = new MockClock();
  }

  @After
  public void teardown() {
    if (resourceManager != null) {
      resourceManager.stop();
      resourceManager = null;
    }
    conf = null;
  }

  private void startResourceManager(float utilizationThreshold) {
    // yarn.scheduler.fair.preemption.cluster-utilization-threshold
    conf.setFloat(FairSchedulerConfiguration.PREEMPTION_THRESHOLD,
        utilizationThreshold);
    resourceManager = new MockRM(conf);
    resourceManager.start();

    scheduler = (FairScheduler)resourceManager.getResourceScheduler();

    scheduler.setClock(clock);
    scheduler.updateInterval = 60 * 1000;
  }

  private ApplicationAttemptId registerNodeAndSubmitApp(
      int memory, int vcores, int appContainers, int appMemory) {
    RMNode node1 = MockNodes.newNodeInfo(
        1, Resources.createResource(memory, vcores), 1, "node1");
    NodeAddedSchedulerEvent nodeEvent1 = new NodeAddedSchedulerEvent(node1);
    scheduler.handle(nodeEvent1);

    System.out.println("Incorrect amount of resources in the cluster" +
        memory + " , " + scheduler.rootMetrics.getAvailableMB());
    System.out.println("Incorrect amount of resources in the cluster" +
        vcores + " , " + scheduler.rootMetrics.getAvailableVirtualCores());

    ApplicationAttemptId app1 = createSchedulingRequest(appMemory, "queueA", "user1", appContainers);
    scheduler.update();
    // Sufficient node check-ins to fully schedule containers
    for (int i = 0; i < appContainers; i++) {
      NodeUpdateSchedulerEvent nodeUpdate1 = new NodeUpdateSchedulerEvent(node1);
      scheduler.handle(nodeUpdate1);
    }
    FSLeafQueue queue = scheduler.getQueueManager().getLeafQueue(
            "queueA", false);
    System.out.println( "queueA : " + queue.getFairShare().getMemory() +
            ", weight : " + queue.getWeights().getWeight(ResourceType.MEMORY) +
            ", steadyShare : " + queue.getSteadyFairShare() +
            ", demand : " + queue.getDemand() +
            ", running : " + queue.getResourceUsage() +
            ", preempt : " + queue.preemptContainer());
    System.out.println("app1's request is not met" +
            (memory - appContainers * appMemory) + " , " +
        scheduler.rootMetrics.getAvailableMB());
    return app1;
  }

  @Test
  public void testPreemptionWithFreeResources() throws Exception {
    PrintWriter out = new PrintWriter(new FileWriter(ALLOC_FILE));
    out.println("<?xml version=\"1.0\"?>");
    out.println("<allocations>");
    out.println("<queue name=\"default\">");
    out.println("<maxResources>0mb,0vcores</maxResources>");
    out.println("</queue>");
    out.println("<queue name=\"queueA\">");
    out.println("<weight>1</weight>");
    out.println("<minResources>1024mb,0vcores</minResources>");
    out.println("</queue>");
    out.println("<queue name=\"queueB\">");
    out.println("<weight>1</weight>");
    out.println("<minResources>1024mb,0vcores</minResources>");
    out.println("</queue>");
    out.println("<defaultMinSharePreemptionTimeout>5</defaultMinSharePreemptionTimeout>");
    out.println("<fairSharePreemptionTimeout>10</fairSharePreemptionTimeout>");
    out.println("</allocations>");
    out.close();

    // 参数0f表示集群资源的使用量超过此值时发生抢占
    startResourceManager(0f);
    // Create node with 4GB memory and 4 vcores
    // 2 个container 1024mb
    ApplicationAttemptId app1 = registerNodeAndSubmitApp(4 * 1024, 4, 2, 1024);

    // Verify submitting another request triggers preemption
    ApplicationAttemptId app2 = createSchedulingRequest(1024, "queueB", "user1", 1, 1);
    scheduler.update();

    clock.tick(6);

    FSLeafQueue queue = scheduler.getQueueManager().getLeafQueue(
            "queueA", false);
    System.out.println( "queueA : " + queue.getFairShare().getMemory() +
            ", weight : " + queue.getWeights().getWeight(ResourceType.MEMORY) +
            ", steadyShare : " + queue.getSteadyFairShare() +
            ", demand : " + queue.getDemand() +
            ", running : " + queue.getResourceUsage() +
            ", preempt : " + queue.preemptContainer());

    scheduler.preemptTasksIfNecessary();
//    System.out.println("preemptResources() should have been called" + 1024 + " , " +
//            ((StubbedFairScheduler) scheduler).lastPreemptMemory);
    System.out.println("preemptResources() should have been called " + 1024 + " , " +
            scheduler.getSchedulerApp(app1).getPreemptionContainers().iterator().next().getContainer().getResource());
    System.out.println("====================================================================");
    clock.tick(18);
    scheduler.preemptTasksIfNecessary();
//    System.out.println("preemptResources() should have been called" + 1024 + " , " +
//            ((StubbedFairScheduler) scheduler).lastPreemptMemory);
    System.out.println("preemptResources() should have been called " + 1024 + " , " +
            scheduler.getSchedulerApp(app1).getPreemptionContainers());
    System.out.println( "queueA : " + queue.getFairShare().getMemory() +
            ", weight : " + queue.getWeights().getWeight(ResourceType.MEMORY) +
            ", steadyShare : " + queue.getSteadyFairShare() +
            ", demand : " + queue.getDemand() +
            ", running : " + queue.getResourceUsage() +
            ", preempt : " + queue.preemptContainer());


    resourceManager.stop();

//    startResourceManager(0.8f);
//    // Create node with 4GB memory and 4 vcores
//    // 3 containers 1024
//    registerNodeAndSubmitApp(4 * 1024, 4, 3, 1024);
//
//    // Verify submitting another request doesn't trigger preemption
//    createSchedulingRequest(1024, "queueB", "user1", 1, 1);
//    scheduler.update();
//    clock.tick(6);
//
//    ((StubbedFairScheduler) scheduler).resetLastPreemptResources();
//    scheduler.preemptTasksIfNecessary();
//    System.out.println("preemptResources() should not have been called" + -1 + " , " +
//        ((StubbedFairScheduler) scheduler).lastPreemptMemory);
//
//    resourceManager.stop();
//
//    startResourceManager(0.7f);
//    // Create node with 4GB memory and 4 vcores
//    registerNodeAndSubmitApp(4 * 1024, 4, 3, 1024);
//
//    // Verify submitting another request triggers preemption
//    createSchedulingRequest(1024, "queueB", "user1", 1, 1);
//    scheduler.update();
//    clock.tick(6);
//
//    ((StubbedFairScheduler) scheduler).resetLastPreemptResources();
//    scheduler.preemptTasksIfNecessary();
//    System.out.println("preemptResources() should have been called" + 1024 + " , " +
//        ((StubbedFairScheduler) scheduler).lastPreemptMemory);
  }
}
