package my.grpc.gateway;

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
    comments = "Source: PushNotificationService.proto")
public final class PushNotificationServiceGrpc {

  private PushNotificationServiceGrpc() {}

  public static final String SERVICE_NAME = "my.grpc.gateway.PushNotificationService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage,
      my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage> METHOD_NOTIFY =
      io.grpc.MethodDescriptor.<my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage, my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "my.grpc.gateway.PushNotificationService", "notify"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage.getDefaultInstance()))
          .setSchemaDescriptor(new PushNotificationServiceMethodDescriptorSupplier("notify"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PushNotificationServiceStub newStub(io.grpc.Channel channel) {
    return new PushNotificationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PushNotificationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PushNotificationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PushNotificationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PushNotificationServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PushNotificationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage> notify(
        io.grpc.stub.StreamObserver<my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_NOTIFY, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_NOTIFY,
            asyncBidiStreamingCall(
              new MethodHandlers<
                my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage,
                my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage>(
                  this, METHODID_NOTIFY)))
          .build();
    }
  }

  /**
   */
  public static final class PushNotificationServiceStub extends io.grpc.stub.AbstractStub<PushNotificationServiceStub> {
    private PushNotificationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PushNotificationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PushNotificationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PushNotificationServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage> notify(
        io.grpc.stub.StreamObserver<my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_NOTIFY, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class PushNotificationServiceBlockingStub extends io.grpc.stub.AbstractStub<PushNotificationServiceBlockingStub> {
    private PushNotificationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PushNotificationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PushNotificationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PushNotificationServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class PushNotificationServiceFutureStub extends io.grpc.stub.AbstractStub<PushNotificationServiceFutureStub> {
    private PushNotificationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PushNotificationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PushNotificationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PushNotificationServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_NOTIFY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PushNotificationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PushNotificationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_NOTIFY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.notify(
              (io.grpc.stub.StreamObserver<my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PushNotificationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PushNotificationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return my.grpc.gateway.PushNotificationServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PushNotificationService");
    }
  }

  private static final class PushNotificationServiceFileDescriptorSupplier
      extends PushNotificationServiceBaseDescriptorSupplier {
    PushNotificationServiceFileDescriptorSupplier() {}
  }

  private static final class PushNotificationServiceMethodDescriptorSupplier
      extends PushNotificationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PushNotificationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PushNotificationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PushNotificationServiceFileDescriptorSupplier())
              .addMethod(METHOD_NOTIFY)
              .build();
        }
      }
    }
    return result;
  }
}
