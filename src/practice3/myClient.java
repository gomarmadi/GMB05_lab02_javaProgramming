package practice3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class myClient {

    private String serverName;
    private Socket client = null;
    private BufferedReader in = null;
    private PrintWriter out = null;
    Scanner sc = new Scanner(System.in);

    public void start(String[] args) throws IOException {
        final int port = 9737;
        final String LOCAL_HOST = "127.0.0.1";

        if (args.length == 0) {
            serverName = LOCAL_HOST;
        } else {
            serverName = args[0];
        }
        try {
            client = new Socket(serverName, port);
        } catch (IOException e) {
            System.exit(0);
        }

        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
            //вот это менять нужно
            System.out.print("Введите а: ");
            int a = sc.nextInt();
            System.out.print("Введите b: ");
            int b = sc.nextInt();
            System.out.print("Введите x: ");
            int x = sc.nextInt();

            out.println(a);
            out.println(b);
            out.println(x);
            out.println("stop");
            
            String answer = in.readLine();

            System.out.println(answer);

        } catch (Exception e) {
            System.exit(0);
        }
    }

    public void stop() throws IOException {
        out.close();
        in.close();
        client.close();
    }
}
