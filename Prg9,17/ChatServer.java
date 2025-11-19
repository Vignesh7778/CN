import java.net.*;
import java.io.*;

public class ChatServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(9004);
        Socket s = ss.accept();

        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));

        String msg;
        while ((msg = in.readLine()) != null)
            System.out.println("Client: " + msg);
    }
}
