package p2p;

import gateway.beans.Node;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import my.grpc.P2PNetServiceGrpc;
import my.grpc.P2PNetServiceOuterClass.AckMessage;
import my.grpc.P2PNetServiceOuterClass.NodeMessage;
import my.grpc.P2PNetServiceOuterClass.TokenMessage;

import static my.grpc.P2PNetServiceGrpc.newBlockingStub;

public class P2PNetServiceImpl extends P2PNetServiceGrpc.P2PNetServiceImplBase {

    final NodesNetwork nodesNetwork;
    String id;
    final Token token;
    final NodeWrapper nodeWrapper;
    final Exiting exiting;

    public P2PNetServiceImpl(NodeWrapper nodeWrapper, String id, Token token, Exiting exiting) {
        this.nodesNetwork = nodeWrapper.nodesNetwork;
        this.id = id;
        this.token = token;
        this.nodeWrapper = nodeWrapper;
        this.exiting = exiting;
    }

    @Override
    public void passToken(TokenMessage tokenMessage, StreamObserver<AckMessage> responseObserver) {
        synchronized(token) {
            responseObserver.onNext(AckMessage.newBuilder().setReceived(true).build());
            responseObserver.onCompleted();
            ManagedChannel channel;
            System.out.println("token at node " + id + " from " + tokenMessage.getPreviousNodeId());
            boolean success = false;
            while (!success) {
                String nextNodeId = nodesNetwork.getNextNodeId();
                tokenMessage = nodeWrapper.updateTokenWithStats(tokenMessage);
                if (!nextNodeId.equals(id)) {
                    try {
                        channel = ManagedChannelBuilder.forTarget(nodeWrapper.getIpAndPort(nextNodeId)).usePlaintext(true).build();
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

    @Override
    public void addNodeToList(NodeMessage request, StreamObserver<AckMessage> responseObserver) {
        nodesNetwork.addNode(request.getId(), new Node(id, request.getIp(), request.getPort()));
        System.out.println(nodesNetwork.getNodes().toString());
        responseObserver.onNext(AckMessage.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void removeNodeFromList(NodeMessage request, StreamObserver<AckMessage> responseObserver) {
        nodesNetwork.removeNode(request.getId());
        System.out.println(nodesNetwork.getNodes().toString());
        responseObserver.onNext(AckMessage.newBuilder().build());
        responseObserver.onCompleted();
    }
}
