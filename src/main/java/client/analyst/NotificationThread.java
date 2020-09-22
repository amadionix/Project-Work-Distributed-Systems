package client.analyst;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import my.grpc.gateway.PushNotificationServiceGrpc.*;
import my.grpc.gateway.PushNotificationServiceOuterClass.*;

import static my.grpc.gateway.PushNotificationServiceGrpc.*;

public class NotificationThread extends Thread {
    private static final String IP = "localhost";
    private static final int PORT = 1341;

    @Override
    public void run() {
        final ManagedChannel channel = ManagedChannelBuilder
                .forTarget(IP+":"+PORT).usePlaintext(true).build();
        PushNotificationServiceStub stub = newStub(channel);
        StreamObserver<NotificationMessage> serverStream =
                stub.notify(new StreamObserver<NotificationMessage>() {
                    @Override
                    public void onNext(NotificationMessage notificationMessage) {
                        System.out.println(notificationMessage.getNotification());
                    }

                    @Override
                    public void onError(Throwable throwable) {
                    }

                    @Override
                    public void onCompleted() {
                    }
                });
    }
}
