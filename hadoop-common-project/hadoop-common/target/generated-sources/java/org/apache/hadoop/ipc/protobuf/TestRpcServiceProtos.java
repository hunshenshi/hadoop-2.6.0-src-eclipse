// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: test_rpc_service.proto

package org.apache.hadoop.ipc.protobuf;

public final class TestRpcServiceProtos {
  private TestRpcServiceProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  /**
   * Protobuf service {@code hadoop.common.TestProtobufRpcProto}
   *
   * <pre>
   **
   * A protobuf service for use in tests
   * </pre>
   */
  public static abstract class TestProtobufRpcProto
      implements com.google.protobuf.Service {
    protected TestProtobufRpcProto() {}

    public interface Interface {
      /**
       * <code>rpc ping(.hadoop.common.EmptyRequestProto) returns (.hadoop.common.EmptyResponseProto);</code>
       */
      public abstract void ping(
              com.google.protobuf.RpcController controller,
              TestProtos.EmptyRequestProto request,
              com.google.protobuf.RpcCallback<TestProtos.EmptyResponseProto> done);

      /**
       * <code>rpc echo(.hadoop.common.EchoRequestProto) returns (.hadoop.common.EchoResponseProto);</code>
       */
      public abstract void echo(
              com.google.protobuf.RpcController controller,
              TestProtos.EchoRequestProto request,
              com.google.protobuf.RpcCallback<TestProtos.EchoResponseProto> done);

      /**
       * <code>rpc error(.hadoop.common.EmptyRequestProto) returns (.hadoop.common.EmptyResponseProto);</code>
       */
      public abstract void error(
              com.google.protobuf.RpcController controller,
              TestProtos.EmptyRequestProto request,
              com.google.protobuf.RpcCallback<TestProtos.EmptyResponseProto> done);

      /**
       * <code>rpc error2(.hadoop.common.EmptyRequestProto) returns (.hadoop.common.EmptyResponseProto);</code>
       */
      public abstract void error2(
              com.google.protobuf.RpcController controller,
              TestProtos.EmptyRequestProto request,
              com.google.protobuf.RpcCallback<TestProtos.EmptyResponseProto> done);

    }

    public static com.google.protobuf.Service newReflectiveService(
        final Interface impl) {
      return new TestProtobufRpcProto() {
        @Override
        public  void ping(
            com.google.protobuf.RpcController controller,
            TestProtos.EmptyRequestProto request,
            com.google.protobuf.RpcCallback<TestProtos.EmptyResponseProto> done) {
          impl.ping(controller, request, done);
        }

        @Override
        public  void echo(
            com.google.protobuf.RpcController controller,
            TestProtos.EchoRequestProto request,
            com.google.protobuf.RpcCallback<TestProtos.EchoResponseProto> done) {
          impl.echo(controller, request, done);
        }

        @Override
        public  void error(
            com.google.protobuf.RpcController controller,
            TestProtos.EmptyRequestProto request,
            com.google.protobuf.RpcCallback<TestProtos.EmptyResponseProto> done) {
          impl.error(controller, request, done);
        }

        @Override
        public  void error2(
            com.google.protobuf.RpcController controller,
            TestProtos.EmptyRequestProto request,
            com.google.protobuf.RpcCallback<TestProtos.EmptyResponseProto> done) {
          impl.error2(controller, request, done);
        }

      };
    }

    public static com.google.protobuf.BlockingService
        newReflectiveBlockingService(final BlockingInterface impl) {
      return new com.google.protobuf.BlockingService() {
        public final com.google.protobuf.Descriptors.ServiceDescriptor
            getDescriptorForType() {
          return getDescriptor();
        }

        public final com.google.protobuf.Message callBlockingMethod(
            com.google.protobuf.Descriptors.MethodDescriptor method,
            com.google.protobuf.RpcController controller,
            com.google.protobuf.Message request)
            throws com.google.protobuf.ServiceException {
          if (method.getService() != getDescriptor()) {
            throw new IllegalArgumentException(
              "Service.callBlockingMethod() given method descriptor for " +
              "wrong service type.");
          }
          switch(method.getIndex()) {
            case 0:
              return impl.ping(controller, (TestProtos.EmptyRequestProto)request);
            case 1:
              return impl.echo(controller, (TestProtos.EchoRequestProto)request);
            case 2:
              return impl.error(controller, (TestProtos.EmptyRequestProto)request);
            case 3:
              return impl.error2(controller, (TestProtos.EmptyRequestProto)request);
            default:
              throw new AssertionError("Can't get here.");
          }
        }

        public final com.google.protobuf.Message
            getRequestPrototype(
            com.google.protobuf.Descriptors.MethodDescriptor method) {
          if (method.getService() != getDescriptor()) {
            throw new IllegalArgumentException(
              "Service.getRequestPrototype() given method " +
              "descriptor for wrong service type.");
          }
          switch(method.getIndex()) {
            case 0:
              return TestProtos.EmptyRequestProto.getDefaultInstance();
            case 1:
              return TestProtos.EchoRequestProto.getDefaultInstance();
            case 2:
              return TestProtos.EmptyRequestProto.getDefaultInstance();
            case 3:
              return TestProtos.EmptyRequestProto.getDefaultInstance();
            default:
              throw new AssertionError("Can't get here.");
          }
        }

        public final com.google.protobuf.Message
            getResponsePrototype(
            com.google.protobuf.Descriptors.MethodDescriptor method) {
          if (method.getService() != getDescriptor()) {
            throw new IllegalArgumentException(
              "Service.getResponsePrototype() given method " +
              "descriptor for wrong service type.");
          }
          switch(method.getIndex()) {
            case 0:
              return TestProtos.EmptyResponseProto.getDefaultInstance();
            case 1:
              return TestProtos.EchoResponseProto.getDefaultInstance();
            case 2:
              return TestProtos.EmptyResponseProto.getDefaultInstance();
            case 3:
              return TestProtos.EmptyResponseProto.getDefaultInstance();
            default:
              throw new AssertionError("Can't get here.");
          }
        }

      };
    }

    /**
     * <code>rpc ping(.hadoop.common.EmptyRequestProto) returns (.hadoop.common.EmptyResponseProto);</code>
     */
    public abstract void ping(
        com.google.protobuf.RpcController controller,
        TestProtos.EmptyRequestProto request,
        com.google.protobuf.RpcCallback<TestProtos.EmptyResponseProto> done);

    /**
     * <code>rpc echo(.hadoop.common.EchoRequestProto) returns (.hadoop.common.EchoResponseProto);</code>
     */
    public abstract void echo(
        com.google.protobuf.RpcController controller,
        TestProtos.EchoRequestProto request,
        com.google.protobuf.RpcCallback<TestProtos.EchoResponseProto> done);

    /**
     * <code>rpc error(.hadoop.common.EmptyRequestProto) returns (.hadoop.common.EmptyResponseProto);</code>
     */
    public abstract void error(
        com.google.protobuf.RpcController controller,
        TestProtos.EmptyRequestProto request,
        com.google.protobuf.RpcCallback<TestProtos.EmptyResponseProto> done);

    /**
     * <code>rpc error2(.hadoop.common.EmptyRequestProto) returns (.hadoop.common.EmptyResponseProto);</code>
     */
    public abstract void error2(
        com.google.protobuf.RpcController controller,
        TestProtos.EmptyRequestProto request,
        com.google.protobuf.RpcCallback<TestProtos.EmptyResponseProto> done);

    public static final
        com.google.protobuf.Descriptors.ServiceDescriptor
        getDescriptor() {
      return TestRpcServiceProtos.getDescriptor().getServices().get(0);
    }
    public final com.google.protobuf.Descriptors.ServiceDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }

    public final void callMethod(
        com.google.protobuf.Descriptors.MethodDescriptor method,
        com.google.protobuf.RpcController controller,
        com.google.protobuf.Message request,
        com.google.protobuf.RpcCallback<
          com.google.protobuf.Message> done) {
      if (method.getService() != getDescriptor()) {
        throw new IllegalArgumentException(
          "Service.callMethod() given method descriptor for wrong " +
          "service type.");
      }
      switch(method.getIndex()) {
        case 0:
          this.ping(controller, (TestProtos.EmptyRequestProto)request,
            com.google.protobuf.RpcUtil.<TestProtos.EmptyResponseProto>specializeCallback(
              done));
          return;
        case 1:
          this.echo(controller, (TestProtos.EchoRequestProto)request,
            com.google.protobuf.RpcUtil.<TestProtos.EchoResponseProto>specializeCallback(
              done));
          return;
        case 2:
          this.error(controller, (TestProtos.EmptyRequestProto)request,
            com.google.protobuf.RpcUtil.<TestProtos.EmptyResponseProto>specializeCallback(
              done));
          return;
        case 3:
          this.error2(controller, (TestProtos.EmptyRequestProto)request,
            com.google.protobuf.RpcUtil.<TestProtos.EmptyResponseProto>specializeCallback(
              done));
          return;
        default:
          throw new AssertionError("Can't get here.");
      }
    }

    public final com.google.protobuf.Message
        getRequestPrototype(
        com.google.protobuf.Descriptors.MethodDescriptor method) {
      if (method.getService() != getDescriptor()) {
        throw new IllegalArgumentException(
          "Service.getRequestPrototype() given method " +
          "descriptor for wrong service type.");
      }
      switch(method.getIndex()) {
        case 0:
          return TestProtos.EmptyRequestProto.getDefaultInstance();
        case 1:
          return TestProtos.EchoRequestProto.getDefaultInstance();
        case 2:
          return TestProtos.EmptyRequestProto.getDefaultInstance();
        case 3:
          return TestProtos.EmptyRequestProto.getDefaultInstance();
        default:
          throw new AssertionError("Can't get here.");
      }
    }

    public final com.google.protobuf.Message
        getResponsePrototype(
        com.google.protobuf.Descriptors.MethodDescriptor method) {
      if (method.getService() != getDescriptor()) {
        throw new IllegalArgumentException(
          "Service.getResponsePrototype() given method " +
          "descriptor for wrong service type.");
      }
      switch(method.getIndex()) {
        case 0:
          return TestProtos.EmptyResponseProto.getDefaultInstance();
        case 1:
          return TestProtos.EchoResponseProto.getDefaultInstance();
        case 2:
          return TestProtos.EmptyResponseProto.getDefaultInstance();
        case 3:
          return TestProtos.EmptyResponseProto.getDefaultInstance();
        default:
          throw new AssertionError("Can't get here.");
      }
    }

    public static Stub newStub(
        com.google.protobuf.RpcChannel channel) {
      return new Stub(channel);
    }

    public static final class Stub extends TestProtobufRpcProto implements Interface {
      private Stub(com.google.protobuf.RpcChannel channel) {
        this.channel = channel;
      }

      private final com.google.protobuf.RpcChannel channel;

      public com.google.protobuf.RpcChannel getChannel() {
        return channel;
      }

      public  void ping(
          com.google.protobuf.RpcController controller,
          TestProtos.EmptyRequestProto request,
          com.google.protobuf.RpcCallback<TestProtos.EmptyResponseProto> done) {
        channel.callMethod(
          getDescriptor().getMethods().get(0),
          controller,
          request,
          TestProtos.EmptyResponseProto.getDefaultInstance(),
          com.google.protobuf.RpcUtil.generalizeCallback(
            done,
            TestProtos.EmptyResponseProto.class,
            TestProtos.EmptyResponseProto.getDefaultInstance()));
      }

      public  void echo(
          com.google.protobuf.RpcController controller,
          TestProtos.EchoRequestProto request,
          com.google.protobuf.RpcCallback<TestProtos.EchoResponseProto> done) {
        channel.callMethod(
          getDescriptor().getMethods().get(1),
          controller,
          request,
          TestProtos.EchoResponseProto.getDefaultInstance(),
          com.google.protobuf.RpcUtil.generalizeCallback(
            done,
            TestProtos.EchoResponseProto.class,
            TestProtos.EchoResponseProto.getDefaultInstance()));
      }

      public  void error(
          com.google.protobuf.RpcController controller,
          TestProtos.EmptyRequestProto request,
          com.google.protobuf.RpcCallback<TestProtos.EmptyResponseProto> done) {
        channel.callMethod(
          getDescriptor().getMethods().get(2),
          controller,
          request,
          TestProtos.EmptyResponseProto.getDefaultInstance(),
          com.google.protobuf.RpcUtil.generalizeCallback(
            done,
            TestProtos.EmptyResponseProto.class,
            TestProtos.EmptyResponseProto.getDefaultInstance()));
      }

      public  void error2(
          com.google.protobuf.RpcController controller,
          TestProtos.EmptyRequestProto request,
          com.google.protobuf.RpcCallback<TestProtos.EmptyResponseProto> done) {
        channel.callMethod(
          getDescriptor().getMethods().get(3),
          controller,
          request,
          TestProtos.EmptyResponseProto.getDefaultInstance(),
          com.google.protobuf.RpcUtil.generalizeCallback(
            done,
            TestProtos.EmptyResponseProto.class,
            TestProtos.EmptyResponseProto.getDefaultInstance()));
      }
    }

    public static BlockingInterface newBlockingStub(
        com.google.protobuf.BlockingRpcChannel channel) {
      return new BlockingStub(channel);
    }

    public interface BlockingInterface {
      public TestProtos.EmptyResponseProto ping(
              com.google.protobuf.RpcController controller,
              TestProtos.EmptyRequestProto request)
          throws com.google.protobuf.ServiceException;

      public TestProtos.EchoResponseProto echo(
              com.google.protobuf.RpcController controller,
              TestProtos.EchoRequestProto request)
          throws com.google.protobuf.ServiceException;

      public TestProtos.EmptyResponseProto error(
              com.google.protobuf.RpcController controller,
              TestProtos.EmptyRequestProto request)
          throws com.google.protobuf.ServiceException;

      public TestProtos.EmptyResponseProto error2(
              com.google.protobuf.RpcController controller,
              TestProtos.EmptyRequestProto request)
          throws com.google.protobuf.ServiceException;
    }

    private static final class BlockingStub implements BlockingInterface {
      private BlockingStub(com.google.protobuf.BlockingRpcChannel channel) {
        this.channel = channel;
      }

      private final com.google.protobuf.BlockingRpcChannel channel;

      public TestProtos.EmptyResponseProto ping(
          com.google.protobuf.RpcController controller,
          TestProtos.EmptyRequestProto request)
          throws com.google.protobuf.ServiceException {
        return (TestProtos.EmptyResponseProto) channel.callBlockingMethod(
          getDescriptor().getMethods().get(0),
          controller,
          request,
          TestProtos.EmptyResponseProto.getDefaultInstance());
      }


      public TestProtos.EchoResponseProto echo(
          com.google.protobuf.RpcController controller,
          TestProtos.EchoRequestProto request)
          throws com.google.protobuf.ServiceException {
        return (TestProtos.EchoResponseProto) channel.callBlockingMethod(
          getDescriptor().getMethods().get(1),
          controller,
          request,
          TestProtos.EchoResponseProto.getDefaultInstance());
      }


      public TestProtos.EmptyResponseProto error(
          com.google.protobuf.RpcController controller,
          TestProtos.EmptyRequestProto request)
          throws com.google.protobuf.ServiceException {
        return (TestProtos.EmptyResponseProto) channel.callBlockingMethod(
          getDescriptor().getMethods().get(2),
          controller,
          request,
          TestProtos.EmptyResponseProto.getDefaultInstance());
      }


      public TestProtos.EmptyResponseProto error2(
          com.google.protobuf.RpcController controller,
          TestProtos.EmptyRequestProto request)
          throws com.google.protobuf.ServiceException {
        return (TestProtos.EmptyResponseProto) channel.callBlockingMethod(
          getDescriptor().getMethods().get(3),
          controller,
          request,
          TestProtos.EmptyResponseProto.getDefaultInstance());
      }

    }

    // @@protoc_insertion_point(class_scope:hadoop.common.TestProtobufRpcProto)
  }

  /**
   * Protobuf service {@code hadoop.common.TestProtobufRpc2Proto}
   */
  public static abstract class TestProtobufRpc2Proto
      implements com.google.protobuf.Service {
    protected TestProtobufRpc2Proto() {}

    public interface Interface {
      /**
       * <code>rpc ping2(.hadoop.common.EmptyRequestProto) returns (.hadoop.common.EmptyResponseProto);</code>
       */
      public abstract void ping2(
              com.google.protobuf.RpcController controller,
              TestProtos.EmptyRequestProto request,
              com.google.protobuf.RpcCallback<TestProtos.EmptyResponseProto> done);

      /**
       * <code>rpc echo2(.hadoop.common.EchoRequestProto) returns (.hadoop.common.EchoResponseProto);</code>
       */
      public abstract void echo2(
              com.google.protobuf.RpcController controller,
              TestProtos.EchoRequestProto request,
              com.google.protobuf.RpcCallback<TestProtos.EchoResponseProto> done);

    }

    public static com.google.protobuf.Service newReflectiveService(
        final Interface impl) {
      return new TestProtobufRpc2Proto() {
        @Override
        public  void ping2(
            com.google.protobuf.RpcController controller,
            TestProtos.EmptyRequestProto request,
            com.google.protobuf.RpcCallback<TestProtos.EmptyResponseProto> done) {
          impl.ping2(controller, request, done);
        }

        @Override
        public  void echo2(
            com.google.protobuf.RpcController controller,
            TestProtos.EchoRequestProto request,
            com.google.protobuf.RpcCallback<TestProtos.EchoResponseProto> done) {
          impl.echo2(controller, request, done);
        }

      };
    }

    public static com.google.protobuf.BlockingService
        newReflectiveBlockingService(final BlockingInterface impl) {
      return new com.google.protobuf.BlockingService() {
        public final com.google.protobuf.Descriptors.ServiceDescriptor
            getDescriptorForType() {
          return getDescriptor();
        }

        public final com.google.protobuf.Message callBlockingMethod(
            com.google.protobuf.Descriptors.MethodDescriptor method,
            com.google.protobuf.RpcController controller,
            com.google.protobuf.Message request)
            throws com.google.protobuf.ServiceException {
          if (method.getService() != getDescriptor()) {
            throw new IllegalArgumentException(
              "Service.callBlockingMethod() given method descriptor for " +
              "wrong service type.");
          }
          switch(method.getIndex()) {
            case 0:
              return impl.ping2(controller, (TestProtos.EmptyRequestProto)request);
            case 1:
              return impl.echo2(controller, (TestProtos.EchoRequestProto)request);
            default:
              throw new AssertionError("Can't get here.");
          }
        }

        public final com.google.protobuf.Message
            getRequestPrototype(
            com.google.protobuf.Descriptors.MethodDescriptor method) {
          if (method.getService() != getDescriptor()) {
            throw new IllegalArgumentException(
              "Service.getRequestPrototype() given method " +
              "descriptor for wrong service type.");
          }
          switch(method.getIndex()) {
            case 0:
              return TestProtos.EmptyRequestProto.getDefaultInstance();
            case 1:
              return TestProtos.EchoRequestProto.getDefaultInstance();
            default:
              throw new AssertionError("Can't get here.");
          }
        }

        public final com.google.protobuf.Message
            getResponsePrototype(
            com.google.protobuf.Descriptors.MethodDescriptor method) {
          if (method.getService() != getDescriptor()) {
            throw new IllegalArgumentException(
              "Service.getResponsePrototype() given method " +
              "descriptor for wrong service type.");
          }
          switch(method.getIndex()) {
            case 0:
              return TestProtos.EmptyResponseProto.getDefaultInstance();
            case 1:
              return TestProtos.EchoResponseProto.getDefaultInstance();
            default:
              throw new AssertionError("Can't get here.");
          }
        }

      };
    }

    /**
     * <code>rpc ping2(.hadoop.common.EmptyRequestProto) returns (.hadoop.common.EmptyResponseProto);</code>
     */
    public abstract void ping2(
        com.google.protobuf.RpcController controller,
        TestProtos.EmptyRequestProto request,
        com.google.protobuf.RpcCallback<TestProtos.EmptyResponseProto> done);

    /**
     * <code>rpc echo2(.hadoop.common.EchoRequestProto) returns (.hadoop.common.EchoResponseProto);</code>
     */
    public abstract void echo2(
        com.google.protobuf.RpcController controller,
        TestProtos.EchoRequestProto request,
        com.google.protobuf.RpcCallback<TestProtos.EchoResponseProto> done);

    public static final
        com.google.protobuf.Descriptors.ServiceDescriptor
        getDescriptor() {
      return TestRpcServiceProtos.getDescriptor().getServices().get(1);
    }
    public final com.google.protobuf.Descriptors.ServiceDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }

    public final void callMethod(
        com.google.protobuf.Descriptors.MethodDescriptor method,
        com.google.protobuf.RpcController controller,
        com.google.protobuf.Message request,
        com.google.protobuf.RpcCallback<
          com.google.protobuf.Message> done) {
      if (method.getService() != getDescriptor()) {
        throw new IllegalArgumentException(
          "Service.callMethod() given method descriptor for wrong " +
          "service type.");
      }
      switch(method.getIndex()) {
        case 0:
          this.ping2(controller, (TestProtos.EmptyRequestProto)request,
            com.google.protobuf.RpcUtil.<TestProtos.EmptyResponseProto>specializeCallback(
              done));
          return;
        case 1:
          this.echo2(controller, (TestProtos.EchoRequestProto)request,
            com.google.protobuf.RpcUtil.<TestProtos.EchoResponseProto>specializeCallback(
              done));
          return;
        default:
          throw new AssertionError("Can't get here.");
      }
    }

    public final com.google.protobuf.Message
        getRequestPrototype(
        com.google.protobuf.Descriptors.MethodDescriptor method) {
      if (method.getService() != getDescriptor()) {
        throw new IllegalArgumentException(
          "Service.getRequestPrototype() given method " +
          "descriptor for wrong service type.");
      }
      switch(method.getIndex()) {
        case 0:
          return TestProtos.EmptyRequestProto.getDefaultInstance();
        case 1:
          return TestProtos.EchoRequestProto.getDefaultInstance();
        default:
          throw new AssertionError("Can't get here.");
      }
    }

    public final com.google.protobuf.Message
        getResponsePrototype(
        com.google.protobuf.Descriptors.MethodDescriptor method) {
      if (method.getService() != getDescriptor()) {
        throw new IllegalArgumentException(
          "Service.getResponsePrototype() given method " +
          "descriptor for wrong service type.");
      }
      switch(method.getIndex()) {
        case 0:
          return TestProtos.EmptyResponseProto.getDefaultInstance();
        case 1:
          return TestProtos.EchoResponseProto.getDefaultInstance();
        default:
          throw new AssertionError("Can't get here.");
      }
    }

    public static Stub newStub(
        com.google.protobuf.RpcChannel channel) {
      return new Stub(channel);
    }

    public static final class Stub extends TestProtobufRpc2Proto implements Interface {
      private Stub(com.google.protobuf.RpcChannel channel) {
        this.channel = channel;
      }

      private final com.google.protobuf.RpcChannel channel;

      public com.google.protobuf.RpcChannel getChannel() {
        return channel;
      }

      public  void ping2(
          com.google.protobuf.RpcController controller,
          TestProtos.EmptyRequestProto request,
          com.google.protobuf.RpcCallback<TestProtos.EmptyResponseProto> done) {
        channel.callMethod(
          getDescriptor().getMethods().get(0),
          controller,
          request,
          TestProtos.EmptyResponseProto.getDefaultInstance(),
          com.google.protobuf.RpcUtil.generalizeCallback(
            done,
            TestProtos.EmptyResponseProto.class,
            TestProtos.EmptyResponseProto.getDefaultInstance()));
      }

      public  void echo2(
          com.google.protobuf.RpcController controller,
          TestProtos.EchoRequestProto request,
          com.google.protobuf.RpcCallback<TestProtos.EchoResponseProto> done) {
        channel.callMethod(
          getDescriptor().getMethods().get(1),
          controller,
          request,
          TestProtos.EchoResponseProto.getDefaultInstance(),
          com.google.protobuf.RpcUtil.generalizeCallback(
            done,
            TestProtos.EchoResponseProto.class,
            TestProtos.EchoResponseProto.getDefaultInstance()));
      }
    }

    public static BlockingInterface newBlockingStub(
        com.google.protobuf.BlockingRpcChannel channel) {
      return new BlockingStub(channel);
    }

    public interface BlockingInterface {
      public TestProtos.EmptyResponseProto ping2(
              com.google.protobuf.RpcController controller,
              TestProtos.EmptyRequestProto request)
          throws com.google.protobuf.ServiceException;

      public TestProtos.EchoResponseProto echo2(
              com.google.protobuf.RpcController controller,
              TestProtos.EchoRequestProto request)
          throws com.google.protobuf.ServiceException;
    }

    private static final class BlockingStub implements BlockingInterface {
      private BlockingStub(com.google.protobuf.BlockingRpcChannel channel) {
        this.channel = channel;
      }

      private final com.google.protobuf.BlockingRpcChannel channel;

      public TestProtos.EmptyResponseProto ping2(
          com.google.protobuf.RpcController controller,
          TestProtos.EmptyRequestProto request)
          throws com.google.protobuf.ServiceException {
        return (TestProtos.EmptyResponseProto) channel.callBlockingMethod(
          getDescriptor().getMethods().get(0),
          controller,
          request,
          TestProtos.EmptyResponseProto.getDefaultInstance());
      }


      public TestProtos.EchoResponseProto echo2(
          com.google.protobuf.RpcController controller,
          TestProtos.EchoRequestProto request)
          throws com.google.protobuf.ServiceException {
        return (TestProtos.EchoResponseProto) channel.callBlockingMethod(
          getDescriptor().getMethods().get(1),
          controller,
          request,
          TestProtos.EchoResponseProto.getDefaultInstance());
      }

    }

    // @@protoc_insertion_point(class_scope:hadoop.common.TestProtobufRpc2Proto)
  }


  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\026test_rpc_service.proto\022\rhadoop.common\032" +
      "\ntest.proto2\313\002\n\024TestProtobufRpcProto\022K\n\004" +
      "ping\022 .hadoop.common.EmptyRequestProto\032!" +
      ".hadoop.common.EmptyResponseProto\022I\n\004ech" +
      "o\022\037.hadoop.common.EchoRequestProto\032 .had" +
      "oop.common.EchoResponseProto\022L\n\005error\022 ." +
      "hadoop.common.EmptyRequestProto\032!.hadoop" +
      ".common.EmptyResponseProto\022M\n\006error2\022 .h" +
      "adoop.common.EmptyRequestProto\032!.hadoop." +
      "common.EmptyResponseProto2\261\001\n\025TestProtob",
      "ufRpc2Proto\022L\n\005ping2\022 .hadoop.common.Emp" +
      "tyRequestProto\032!.hadoop.common.EmptyResp" +
      "onseProto\022J\n\005echo2\022\037.hadoop.common.EchoR" +
      "equestProto\032 .hadoop.common.EchoResponse" +
      "ProtoB<\n\036org.apache.hadoop.ipc.protobufB" +
      "\024TestRpcServiceProtos\210\001\001\240\001\001"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          TestProtos.getDescriptor(),
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
