package gateway.services;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer extends Thread {

    private final Server server;

    public GrpcServer(String port) {
        server = ServerBuilder
                .forPort(Integer.parseInt(port))
                .addService(new PushNotificationServiceImpl())
                .build();
    }

    @Override
    public void run() {
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        server.shutdown();
    }

}

