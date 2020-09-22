package my.grpc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.7.0)",
    comments = "Source: P2PNetService.proto")
public final class P2PNetServiceGrpc {

  private P2PNetServiceGrpc() {}

  public static final String SERVICE_NAME = "my.grpc.P2PNetService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<my.grpc.P2PNetServiceOuterClass.NodeMessage,
      my.grpc.P2PNetServiceOuterClass.AckMessage> METHOD_ADD_NODE_TO_LIST =
      io.grpc.MethodDescriptor.<my.grpc.P2PNetServiceOuterClass.NodeMessage, my.grpc.P2PNetServiceOuterClass.AckMessage>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "my.grpc.P2PNetService", "addNodeToList"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              my.grpc.P2PNetServiceOuterClass.NodeMessage.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              my.grpc.P2PNetServiceOuterClass.AckMessage.getDefaultInstance()))
          .setSchemaDescriptor(new P2PNetServiceMethodDescriptorSupplier("addNodeToList"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<my.grpc.P2PNetServiceOuterClass.NodeMessage,
      my.grpc.P2PNetServiceOuterClass.AckMessage> METHOD_REMOVE_NODE_FROM_LIST =
      io.grpc.MethodDescriptor.<my.grpc.P2PNetServiceOuterClass.NodeMessage, my.grpc.P2PNetServiceOuterClass.AckMessage>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "my.grpc.P2PNetService", "removeNodeFromList"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              my.grpc.P2PNetServiceOuterClass.NodeMessage.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              my.grpc.P2PNetServiceOuterClass.AckMessage.getDefaultInstance()))
          .setSchemaDescriptor(new P2PNetServiceMethodDescriptorSupplier("removeNodeFromList"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<my.grpc.P2PNetServiceOuterClass.TokenMessage,
      my.grpc.P2PNetServiceOuterClass.AckMessage> METHOD_PASS_TOKEN =
      io.grpc.MethodDescriptor.<my.grpc.P2PNetServiceOuterClass.TokenMessage, my.grpc.P2PNetServiceOuterClass.AckMessage>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "my.grpc.P2PNetService", "passToken"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              my.grpc.P2PNetServiceOuterClass.TokenMessage.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              my.grpc.P2PNetServiceOuterClass.AckMessage.getDefaultInstance()))
          .setSchemaDescriptor(new P2PNetServiceMethodDescriptorSupplier("passToken"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static P2PNetServiceStub newStub(io.grpc.Channel channel) {
    return new P2PNetServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static P2PNetServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new P2PNetServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static P2PNetServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new P2PNetServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class P2PNetServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addNodeToList(my.grpc.P2PNetServiceOuterClass.NodeMessage request,
        io.grpc.stub.StreamObserver<my.grpc.P2PNetServiceOuterClass.AckMessage> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_NODE_TO_LIST, responseObserver);
    }

    /**
     */
    public void removeNodeFromList(my.grpc.P2PNetServiceOuterClass.NodeMessage request,
        io.grpc.stub.StreamObserver<my.grpc.P2PNetServiceOuterClass.AckMessage> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_REMOVE_NODE_FROM_LIST, responseObserver);
    }

    /**
     */
    public void passToken(my.grpc.P2PNetServiceOuterClass.TokenMessage request,
        io.grpc.stub.StreamObserver<my.grpc.P2PNetServiceOuterClass.AckMessage> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_PASS_TOKEN, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ADD_NODE_TO_LIST,
            asyncUnaryCall(
              new MethodHandlers<
                my.grpc.P2PNetServiceOuterClass.NodeMessage,
                my.grpc.P2PNetServiceOuterClass.AckMessage>(
                  this, METHODID_ADD_NODE_TO_LIST)))
          .addMethod(
            METHOD_REMOVE_NODE_FROM_LIST,
            asyncUnaryCall(
              new MethodHandlers<
                my.grpc.P2PNetServiceOuterClass.NodeMessage,
                my.grpc.P2PNetServiceOuterClass.AckMessage>(
                  this, METHODID_REMOVE_NODE_FROM_LIST)))
          .addMethod(
            METHOD_PASS_TOKEN,
            asyncUnaryCall(
              new MethodHandlers<
                my.grpc.P2PNetServiceOuterClass.TokenMessage,
                my.grpc.P2PNetServiceOuterClass.AckMessage>(
                  this, METHODID_PASS_TOKEN)))
          .build();
    }
  }

  /**
   */
  public static final class P2PNetServiceStub extends io.grpc.stub.AbstractStub<P2PNetServiceStub> {
    private P2PNetServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private P2PNetServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected P2PNetServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new P2PNetServiceStub(channel, callOptions);
    }

    /**
     */
    public void addNodeToList(my.grpc.P2PNetServiceOuterClass.NodeMessage request,
        io.grpc.stub.StreamObserver<my.grpc.P2PNetServiceOuterClass.AckMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_NODE_TO_LIST, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeNodeFromList(my.grpc.P2PNetServiceOuterClass.NodeMessage request,
        io.grpc.stub.StreamObserver<my.grpc.P2PNetServiceOuterClass.AckMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_REMOVE_NODE_FROM_LIST, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void passToken(my.grpc.P2PNetServiceOuterClass.TokenMessage request,
        io.grpc.stub.StreamObserver<my.grpc.P2PNetServiceOuterClass.AckMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PASS_TOKEN, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class P2PNetServiceBlockingStub extends io.grpc.stub.AbstractStub<P2PNetServiceBlockingStub> {
    private P2PNetServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private P2PNetServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected P2PNetServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new P2PNetServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public my.grpc.P2PNetServiceOuterClass.AckMessage addNodeToList(my.grpc.P2PNetServiceOuterClass.NodeMessage request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_NODE_TO_LIST, getCallOptions(), request);
    }

    /**
     */
    public my.grpc.P2PNetServiceOuterClass.AckMessage removeNodeFromList(my.grpc.P2PNetServiceOuterClass.NodeMessage request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REMOVE_NODE_FROM_LIST, getCallOptions(), request);
    }

    /**
     */
    public my.grpc.P2PNetServiceOuterClass.AckMessage passToken(my.grpc.P2PNetServiceOuterClass.TokenMessage request) {
      return blockingUnaryCall(
          getChannel(), METHOD_PASS_TOKEN, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class P2PNetServiceFutureStub extends io.grpc.stub.AbstractStub<P2PNetServiceFutureStub> {
    private P2PNetServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private P2PNetServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected P2PNetServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new P2PNetServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<my.grpc.P2PNetServiceOuterClass.AckMessage> addNodeToList(
        my.grpc.P2PNetServiceOuterClass.NodeMessage request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_NODE_TO_LIST, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<my.grpc.P2PNetServiceOuterClass.AckMessage> removeNodeFromList(
        my.grpc.P2PNetServiceOuterClass.NodeMessage request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_REMOVE_NODE_FROM_LIST, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<my.grpc.P2PNetServiceOuterClass.AckMessage> passToken(
        my.grpc.P2PNetServiceOuterClass.TokenMessage request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PASS_TOKEN, getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_NODE_TO_LIST = 0;
  private static final int METHODID_REMOVE_NODE_FROM_LIST = 1;
  private static final int METHODID_PASS_TOKEN = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final P2PNetServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(P2PNetServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_NODE_TO_LIST:
          serviceImpl.addNodeToList((my.grpc.P2PNetServiceOuterClass.NodeMessage) request,
              (io.grpc.stub.StreamObserver<my.grpc.P2PNetServiceOuterClass.AckMessage>) responseObserver);
          break;
        case METHODID_REMOVE_NODE_FROM_LIST:
          serviceImpl.removeNodeFromList((my.grpc.P2PNetServiceOuterClass.NodeMessage) request,
              (io.grpc.stub.StreamObserver<my.grpc.P2PNetServiceOuterClass.AckMessage>) responseObserver);
          break;
        case METHODID_PASS_TOKEN:
          serviceImpl.passToken((my.grpc.P2PNetServiceOuterClass.TokenMessage) request,
              (io.grpc.stub.StreamObserver<my.grpc.P2PNetServiceOuterClass.AckMessage>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class P2PNetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    P2PNetServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return my.grpc.P2PNetServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("P2PNetService");
    }
  }

  private static final class P2PNetServiceFileDescriptorSupplier
      extends P2PNetServiceBaseDescriptorSupplier {
    P2PNetServiceFileDescriptorSupplier() {}
  }

  private static final class P2PNetServiceMethodDescriptorSupplier
      extends P2PNetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    P2PNetServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (P2PNetServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new P2PNetServiceFileDescriptorSupplier())
              .addMethod(METHOD_ADD_NODE_TO_LIST)
              .addMethod(METHOD_REMOVE_NODE_FROM_LIST)
              .addMethod(METHOD_PASS_TOKEN)
              .build();
        }
      }
    }
    return result;
  }
}
