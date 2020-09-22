package p2p;

public class Exiting {

    private boolean value;
    public Exiting() {
        value = false;
    }

    public synchronized boolean isTrue() {
        return value;
    }

    public synchronized void setValue(boolean value) {
        this.value = value;
    }
}
