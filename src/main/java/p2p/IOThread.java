package p2p;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOThread extends Thread {

    public void run() {
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Type 'q' if you want to leave the network");
            String quit = null;
            try {
                quit = inFromUser.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (quit != null && quit.equals("q")) {
                break;
            }
        }
    }
}
