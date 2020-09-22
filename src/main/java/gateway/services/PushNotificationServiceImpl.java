package gateway.services;

import io.grpc.stub.StreamObserver;
import my.grpc.gateway.PushNotificationServiceGrpc.PushNotificationServiceImplBase;
import my.grpc.gateway.PushNotificationServiceOuterClass.NotificationMessage;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class PushNotificationServiceImpl extends PushNotificationServiceImplBase {

    final HashSet<StreamObserver> observers = new LinkedHashSet<>();

    @Override
    public StreamObserver<NotificationMessage> notify(StreamObserver<NotificationMessage> responseObserver) {
        synchronized (observers) {
            observers.add(responseObserver);
        }

        return new StreamObserver<NotificationMessage>() {

            @Override
            public void onNext(NotificationMessage notificationMessage) {

                    HashSet<StreamObserver> copy;
                    synchronized (observers) {
                        copy = new HashSet<>(observers);
                    }
                    for (StreamObserver<NotificationMessage> observer : copy) {
                        try {
                            observer.onNext(NotificationMessage.newBuilder()
                                    .setNotification(notificationMessage.getNotification()).build());
                        } catch (io.grpc.StatusRuntimeException e) {
                            //peer no longer available
                            synchronized (observers) {
                                observers.remove(responseObserver);
                            }
                        }
                    }
            }
            //if there is an error (client abruptly disconnect) we remove the client.
            public void onError(Throwable throwable) {
                synchronized (observers) {
                    observers.remove(responseObserver);
                }
            }
            //if the client explicitly terminated, we remove it from the hashset.
            public void onCompleted() {
                synchronized (observers) {
                    observers.remove(responseObserver);
                }
            }
        };

    }

}
