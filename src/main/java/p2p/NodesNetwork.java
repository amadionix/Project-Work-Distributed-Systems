package p2p;

import com.sun.jersey.api.client.ClientResponse;
import gateway.beans.Node;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class NodesNetwork {
    private final TreeMap<String, Node> nodes;
    private final String id;
    String nextNodeId;

    public NodesNetwork(ClientResponse response, String id) {
        this.id = id;
        nodes = new TreeMap<>();
        try {
            pullNodesListFromGateway(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        updateNextNodeId();
    }

    public synchronized String getNextNodeId() {
        return nextNodeId;
    }

    public synchronized TreeMap<String, Node> getNodes() {
        return nodes;
    }

    public synchronized int getSize() {
        return nodes.size();
    }

    public synchronized Node getNode(String id) {
        return nodes.get(id);
    }

    public synchronized void addNode(String id, Node node) {
        nodes.put(id, node);
        updateNextNodeId();
    }

    public synchronized void removeNode(String id) {
        nodes.remove(id);
        updateNextNodeId();
    }

    private void updateNextNodeId() {
        String curId = id;
        for (Map.Entry<String, Node> entry: nodes.entrySet()) {
            curId = entry.getKey();
            if (curId.compareTo(id) > 0) {
                break;
            }
            if (curId.equals(nodes.lastKey())) {
                curId = nodes.firstKey();
            }
        }
        nextNodeId = curId;
    }

    private void pullNodesListFromGateway(ClientResponse response) throws IOException {
        String nodesString = response.getEntity(String.class);
        ObjectMapper mapper = new ObjectMapper();
        ArrayList arrayList = mapper.readValue(nodesString, ArrayList.class);
        for (int i = 0; i < arrayList.size(); i++) {
            LinkedHashMap nodeMap = (LinkedHashMap) arrayList.get(i);
            Node node = new Node((String)nodeMap.get("id"), (String)nodeMap.get("ip"), (String)nodeMap.get("port"));
            nodes.put(node.getId(), node);
        }
    }
}
