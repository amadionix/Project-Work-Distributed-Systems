package gateway.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SDAndMean {
    double sd;
    double mean;

    public SDAndMean() {
    }

    public SDAndMean(double sd, double mean) {
        this.sd = sd;
        this.mean = mean;
    }

    public double getSd() {
        return sd;
    }

    public void setSd(int sd) {
        this.sd = sd;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(int mean) {
        this.mean = mean;
    }
}
