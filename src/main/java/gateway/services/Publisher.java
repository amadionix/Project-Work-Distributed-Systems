package gateway.services;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import my.grpc.gateway.PushNotificationServiceGrpc.PushNotificationServiceStub;
import my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage;

import static my.grpc.gateway.PushNotificationServiceGrpc.newStub;

public class Publisher {

    private static Publisher instance;

    StreamObserver<NotificationMessage> serverStream;
    ManagedChannel channel;

    public Publisher() {
        final String HOST = "localhost";
        final int PORT = 1341;
        channel = ManagedChannelBuilder
                .forTarget(HOST + ":" + PORT).usePlaintext(true).build();
        PushNotificationServiceStub stub = newStub(channel);

        serverStream = stub.notify(new StreamObserver<NotificationMessage>() {
            @Override
            public void onNext(NotificationMessage notificationMessage) {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onCompleted() {
            }
        });
    }

    //singleton
    public synchronized static Publisher getInstance(){
        if(instance==null)
            instance = new Publisher();
        return instance;
    }

    public void publish(String notification) {
        NotificationMessage notificationMessage = NotificationMessage.newBuilder()
                .setNotification(notification)
                .build();
        serverStream.onNext(notificationMessage);

    }

    public void close() {
        channel.shutdown();
    }
}
