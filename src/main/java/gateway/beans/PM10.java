package gateway.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PM10 {
    double value;
    String timestamp;

    public PM10() {
    }

    public PM10(double value, String timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
