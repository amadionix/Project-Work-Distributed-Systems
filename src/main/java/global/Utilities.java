package global;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import gateway.beans.Node;
import gateway.beans.PM10;

import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utilities {

    public static ClientResponse addStat(PM10 stat) {
        String gatewayUrl = "http://localhost:1337/gateway/";
        Client client = Client.create();
        WebResource resource = client.resource(gatewayUrl + "add-stat");
        ClientResponse response = resource.type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, stat);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatusInfo());
        }
        return response;
    }

    public static Node createNode() throws IOException {
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));
        String ip = "localhost";
        System.out.println("What is this node's ID?");
        String id = inFromUser.readLine();
        System.out.println("What is this node's port number?");
        String port = inFromUser.readLine();
        return new Node(id, ip, port);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static ClientResponse registerNodeToGateway(String gatewayUrl, Node node) {
        Client client = Client.create();
        WebResource resource = client.resource(gatewayUrl + "add-node");
        ClientResponse response = resource.type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, node);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatusInfo() + "(probably node" +
                    "already in the gateway");
        }
        return response;
    }

}
