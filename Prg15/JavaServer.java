import java.net.*;
import java.io.*;

public class JavaServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(9008);
        System.out.println("Java Server running...");

        Socket s = ss.accept();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));

        String msg = in.readLine();
        System.out.println("Client says: " + msg);

        s.close();
        ss.close();
    }
}
