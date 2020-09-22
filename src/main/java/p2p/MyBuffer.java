package p2p;

import simulators.Buffer;
import simulators.Measurement;

import java.util.LinkedList;

import static global.Utilities.*;

public class MyBuffer implements Buffer {
    private LinkedList<Measurement> buffer;
    private double avg;

    public MyBuffer() {
        this.buffer = new LinkedList<>();
    }

    @Override
    public void addMeasurement(Measurement m) {
        buffer.add(m);
        if (buffer.size() == 18) {
            for (int i = 0; i < 6; i++) {
                buffer.poll();
            }
        }
        if (buffer.size() == 12) {
            avg = getAverage();
        }
    }

    private double getAverage() {
        double curSum = 0;
        for (int i = 0; i < 12; i++) {
            curSum += buffer.get(i).getValue();
        }
        return round(curSum / 12, 2);
    }

    public int getMeasurementsCount() {
        return buffer.size();
    }

    public double getSamplesAvg() {
        return avg;
    }
}
