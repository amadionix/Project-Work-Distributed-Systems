package client.analyst;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Analyst {
    public static void main(String[] args) {
        NotificationThread notificationThread = new NotificationThread();
        notificationThread.start();
        String welcomeMsg =
                "Welcome to the pollution monitoring system of a-random-neighborhood!\n" +
                "The following are my functionalities:\n" +
                "(formatted as 'command for you to type: info I will show you.')\n";
        String menu =
                "1: HOW MANY NODES currently registered to the system.\n" +

                "2: MOST RECENT STATISTICS about pollution in the neighborhood.\n" +

                "3: STANDARD DEVIATION (SD) & MEAN of recent statistics.\n" +

                "4: HOW MANY STATISTICS received so far.\n" +

                "5: quit\n";

        System.out.println(welcomeMsg);

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        String gatewayUrl = "http://localhost:1337/gateway/";
        HttpClient httpClient = HttpClients.createDefault();

        while (true) {
            int action = 5;
            System.out.println(menu);
            try {
                action = Integer.parseInt(inFromUser.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (action == 5) {
                break;
            } else if (action == 1) {
                try {
                    HttpGet getRequest = new HttpGet(gatewayUrl + "network-size");
                    HttpResponse response = httpClient.execute(getRequest);
                    String networkSize = EntityUtils.toString(response.getEntity());
                    if (networkSize.equals("1")) {
                        System.out.println("There is currently " + networkSize + " node in the network.\n");
                    } else {
                        System.out.println("There are currently " + networkSize + " nodes in the network.\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (action == 2) {
                System.out.println("How many statistics would you like to see?");
                String n;
                try {
                    n = inFromUser.readLine();
                    HttpGet getRequest = new HttpGet(gatewayUrl + "last-" + n + "-stats");
                    HttpResponse response = httpClient.execute(getRequest);
                    JSONArray recentStats = new JSONArray(EntityUtils.toString(response.getEntity()));
                    System.out.println("Last " + n + " stats (from the least to the most recent):");
                    for (int i = 0, size = recentStats.length(); i < size; i++) {
                        System.out.println(recentStats.getJSONObject(i).toString());
                    }
                    System.out.println();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if (action == 3) {
                System.out.println("How many statistics would you like to consider?");
                String n;
                try {
                    n = inFromUser.readLine();
                    HttpGet getRequest = new HttpGet(gatewayUrl + "sd-and-mean-of-last-" + n + "-stats");
                    HttpResponse response = httpClient.execute(getRequest);
                    JSONObject j = new JSONObject(EntityUtils.toString(response.getEntity()));
                    System.out.println("SD: " + String.format("%.2f",
                            Double.parseDouble(j.get("sd").toString())));
                    System.out.println("Mean: " + String.format("%.2f",
                            Double.parseDouble(j.get("mean").toString())) + "\n");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if (action == 4) {
                try {
                    HttpGet getRequest = new HttpGet(gatewayUrl + "stats-count");
                    HttpResponse response = httpClient.execute(getRequest);
                    String statsCount = EntityUtils.toString(response.getEntity());
                    System.out.println("Number of stats received so far: " + statsCount + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Please insert a valid option\n");
            }

        }
    }

}
