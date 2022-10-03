package practice3;

import java.io.IOException;

public class startClient {
    public static void main(String[] args) throws IOException {
        myClient client = new myClient();
        client.start(args);
    }

}
