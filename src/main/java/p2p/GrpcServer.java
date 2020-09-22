package p2p;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer extends Thread {

    NodeWrapper nodeWrapper;
    String port;
    Server server;
    final Token token;
    Exiting exiting;

    public GrpcServer(NodeWrapper nodeWrapper, String port, String id, Token token, Exiting exiting) {
        this.nodeWrapper = nodeWrapper;
        this.port = port;
        this.token = token;
        this.exiting = exiting;
        server = ServerBuilder
                .forPort(Integer.parseInt(port))
                .addService(new P2PNetServiceImpl(nodeWrapper, id, token, exiting))
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
        exiting.setValue(true);
        synchronized (token) {
            server.shutdown();
            try {
                server.awaitTermination();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
