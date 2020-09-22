package gateway.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

import static global.Utilities.round;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Stats {

    private final List<PM10> stats;

    private static Stats instance;

    public Stats() {
        stats = new LinkedList<>();
    }

    //singleton
    public synchronized static Stats getInstance(){
        // synchronize to avoid creation of 2 instances
        if (instance == null) {
            instance = new Stats();
        }
        return instance;
    }

    public synchronized int getStatsSize() {
        return stats.size();
    }

    public synchronized List<PM10> getLastNStats(int n) {
        // only returns a view, not a real new list, but it should be fine
        return stats.subList(stats.size() - n, stats.size());
    }

    public synchronized double getMean(int n) {
        double curSum = 0;
        for (int i = 0; i < n; i++) {
            curSum += stats.get(i).getValue();
        }
        return round(curSum / n, 2);
    }

    public synchronized double getSD(int n, double mean) {
        double curDoubleSum = 0;
        for (int i = 0; i < n; i++) {
            curDoubleSum += Math.pow(stats.get(i).getValue() - mean, 2);
        }
        return Math.sqrt(curDoubleSum / n);
    }

    public synchronized void addStats(PM10 stat) {
        stats.add(stat);
    }
}
