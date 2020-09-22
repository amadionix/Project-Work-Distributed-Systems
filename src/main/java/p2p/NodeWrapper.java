package p2p;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import gateway.beans.Node;
import gateway.beans.PM10;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import my.grpc.P2PNetServiceGrpc;
import my.grpc.P2PNetServiceGrpc.P2PNetServiceBlockingStub;
import my.grpc.P2PNetServiceOuterClass;
import my.grpc.P2PNetServiceOuterClass.NodeMessage;
import my.grpc.P2PNetServiceOuterClass.TokenMessage;

import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.TimeZone;

import static global.Utilities.addStat;
import static global.Utilities.round;
import static my.grpc.P2PNetServiceGrpc.newBlockingStub;

public class NodeWrapper {
    final Node node;
    final NodesNetwork nodesNetwork;
    final String id;
    final String gatewayUrl;
    NodeMessage localNodeProtoMessage;
    final Token token;
    final MyBuffer buffer;
    final Exiting exiting;

    public NodeWrapper(NodesNetwork nodesNetwork, Node node, String gatewayUrl, Token token, MyBuffer buffer, Exiting exiting) {
        this.node = node;
        this.nodesNetwork = nodesNetwork;
        this.id = node.getId();
        this.gatewayUrl = gatewayUrl;
        this.token = token;
        this.buffer = buffer;
        this.exiting = exiting;
        localNodeProtoMessage = createLocalNodeProtoMessage();
    }

    public void startToken() {
        synchronized (token) {
            TokenMessage tokenMessage = initializeTokenMessage();
            ManagedChannel channel;
            boolean success = false;
            while (!success) {
                String nextNodeId = nodesNetwork.getNextNodeId();
                tokenMessage = updateTokenWithStats(tokenMessage);
                if (!nextNodeId.equals(id)) {
                    try {
                        channel = ManagedChannelBuilder.forTarget(getIpAndPort(nextNodeId)).usePlaintext(true).build();
                        P2PNetServiceGrpc.P2PNetServiceBlockingStub stub = newBlockingStub(channel);
                        success = stub.passToken(tokenMessage).getReceived();
                        channel.shutdown();
                    } catch (Exception e) {
                        success = false;
                    }
                } else if (exiting.isTrue()) {
                    break;
                }
            }
        }
    }

    public TokenMessage updateTokenWithStats(TokenMessage tokenMessage) {
        double pollutionValue;
        TokenMessage updatedTokenMessage;
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (buffer.getMeasurementsCount() >= 12) {
            pollutionValue = buffer.getSamplesAvg();
            if (tokenMessage.getSamplesCount() + 1 >= tokenMessage.getRingSize()) {
                addValueAndSendStats(tokenMessage, pollutionValue);
                // initialize token
                updatedTokenMessage = createTokenMessageProto(nodesNetwork.getSize(), 0, pollutionValue);
            } else {
                // contribute to token with your stats
                updatedTokenMessage = createTokenMessageProto(tokenMessage.getRingSize(),
                        tokenMessage.getSamplesCount() + 1,
                        tokenMessage.getPollutionValuesSum() + pollutionValue);
            }
        } else {
            // skip because your buffer not big enough yet
            updatedTokenMessage = createTokenMessageProto(tokenMessage.getRingSize(),
                    tokenMessage.getSamplesCount(),
                    tokenMessage.getPollutionValuesSum());
        }
        return updatedTokenMessage;
    }

    private void addValueAndSendStats(P2PNetServiceOuterClass.TokenMessage tokenMessage, double pollutionValue) {
        double avg = round((tokenMessage.getPollutionValuesSum() + pollutionValue)
                / tokenMessage.getRingSize(), 2);
        String timestamp = String.format("%tT", System.currentTimeMillis() -
                TimeZone.getDefault().getRawOffset());
        addStat(new PM10(avg, timestamp));
    }

    private P2PNetServiceOuterClass.TokenMessage createTokenMessageProto(long ringSize, long count, double val) {
        return P2PNetServiceOuterClass.TokenMessage.newBuilder()
                .setRingSize(ringSize)
                .setSamplesCount(count)
                .setPollutionValuesSum(val)
                .setPreviousNodeId(id)
                .build();
    }

    public void removeNodeFromPeersNetwork() {
        String peerID;
        ManagedChannel channel;
        for (Map.Entry<String, Node> entry : nodesNetwork.getNodes().entrySet()) {
            peerID = entry.getKey();
            if (peerID.equals(id)) {
                continue;
            }
            channel = ManagedChannelBuilder.forTarget(getIpAndPort(peerID)).usePlaintext(true).build();
            P2PNetServiceBlockingStub stub = newBlockingStub(channel);
            stub.removeNodeFromList(localNodeProtoMessage);
            channel.shutdown();
        }
    }

    public void RegisterNodeToPeersNetwork() {
        String peerID;
        ManagedChannel channel;
        for (Map.Entry<String, Node> entry : nodesNetwork.getNodes().entrySet()) {
            peerID = entry.getKey();
            if (peerID.equals(id)) {
                continue;
            }
            channel = ManagedChannelBuilder.forTarget(getIpAndPort(peerID)).usePlaintext(true).build();
            P2PNetServiceBlockingStub stub = newBlockingStub(channel);
            stub.addNodeToList(localNodeProtoMessage);
            channel.shutdown();
        }
    }

    private NodeMessage createLocalNodeProtoMessage() {
        return NodeMessage.newBuilder()
                .setId(id)
                .setIp(node.getIp())
                .setPort(node.getPort())
                .build();
    }

    private TokenMessage initializeTokenMessage() {
        return TokenMessage.newBuilder()
                .setRingSize(nodesNetwork.getSize())
                .setSamplesCount(0)
                .setPollutionValuesSum(0)
                .setPreviousNodeId(id)
                .build();
    }

    public String getIpAndPort(String id) {
        return nodesNetwork.getNode(id).getIp() + ":" + nodesNetwork.getNode(id).getPort();
    }

    public void removeNodeFromGateway() {
        Client client = Client.create();
        WebResource resource = client.resource(gatewayUrl + "remove-node");
        resource.type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class, node);
    }



}
