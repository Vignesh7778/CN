import java.net.*;
import java.io.*;

public class ChatClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 9004);
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        BufferedReader kb = new BufferedReader(
            new InputStreamReader(System.in));

        while (true)
            out.println(kb.readLine());
    }
}
