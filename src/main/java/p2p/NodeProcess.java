package p2p;

import com.sun.jersey.api.client.ClientResponse;
import gateway.beans.Node;
import simulators.PM10Simulator;

import java.io.IOException;

import static global.Utilities.createNode;
import static global.Utilities.registerNodeToGateway;

public class NodeProcess {

    public static void main(String[] args) {
        String gatewayUrl = "http://localhost:1337/gateway/";
        Node node = null;
        NodesNetwork nodesNetwork;
        MyBuffer nodeBuffer;
        Token token;
        NodeWrapper nodeWrapper;
        GrpcServer grpcServer;
        IOThread ioThread;
        PM10Simulator simulator;
        ClientResponse response;
        Exiting exiting;

        try {
            node = createNode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert node != null;
        response = registerNodeToGateway(gatewayUrl, node);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Node with same ID already present.");
        }

        nodesNetwork = new NodesNetwork(response, node.getId());
        nodeBuffer = new MyBuffer();
        token = new Token();
        exiting = new Exiting();
        nodeWrapper = new NodeWrapper(nodesNetwork, node, gatewayUrl, token, nodeBuffer, exiting);
        grpcServer = new GrpcServer(nodeWrapper, node.getPort(), node.getId(), token, exiting);
        ioThread = new IOThread();
        simulator = new PM10Simulator(nodeBuffer);


        grpcServer.start();
        nodeWrapper.RegisterNodeToPeersNetwork();
        ioThread.start();
        simulator.start();

        if (nodesNetwork.getSize() == 1) {
            nodeWrapper.startToken();
        }

        try {
            ioThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nodeWrapper.removeNodeFromGateway();
        nodeWrapper.removeNodeFromPeersNetwork();
        grpcServer.close();
        simulator.stopMeGently();
    }



}
