package gateway;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;
import gateway.services.GrpcServer;

import java.io.IOException;

public class StartServer {

    private static final String HOST = "localhost";
    private static final int PORT_REST = 1337;
    private static final int PORT_GRPC = 1341;

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServerFactory.create("http://"+HOST+":"+PORT_REST+"/");
        server.start();

        GrpcServer grpcServer = new GrpcServer(String.valueOf(PORT_GRPC));
        grpcServer.start();

        System.out.println("Server running!");
        System.out.println("Server started on: http://"+HOST+":"+PORT_REST);

        System.out.println("Hit return to stop...");
        System.in.read();
        System.out.println("Stopping rest server");
        server.stop(0);
        System.out.println("Rest server stopped");
        System.out.println("Stopping grpc server");
        grpcServer.close();
        System.out.println("Grpc server stopped");
    }
}

