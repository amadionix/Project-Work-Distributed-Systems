package gateway.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Nodes {

    @XmlElement(name="user")
    private final List<Node> nodes;

    private static Nodes instance;

    private Nodes() {
        nodes = new ArrayList<Node>();
    }

    //singleton
    public synchronized static Nodes getInstance(){
        if(instance==null)
            instance = new Nodes();
        return instance;
    }

    public static boolean contains(String id) {
        for (Node node: getInstance().nodes) {
            if (node.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public synchronized List<Node> getNodes() {
        return new ArrayList<>(nodes);
    }

    public void add(Node node){
        nodes.add(node);
    }

    public void remove(String id) {
        Node node;
        int i;
        for (i = 0; i < getInstance().nodes.size(); i++) {
            node = getInstance().nodes.get(i);
            if (node.getId().equals(id)) {
                break;
            }
        }
        nodes.remove(i);
    }

    public synchronized Object getNodesSetSize() {
        return nodes.size();
    }
}
