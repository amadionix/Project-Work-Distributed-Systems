package gateway.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Node {

    private String id;
    private String ip;
    private String port;

    public Node() {
    }

    public Node(String id, String ip, String port) {
        this.ip = ip;
        this.port = port;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
