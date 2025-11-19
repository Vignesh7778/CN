import java.net.*;
import java.io.*;

public class ChatTwoWay {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 9006);

        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        new Thread(() -> {
            try {
                String msg;
                while ((msg = in.readLine()) != null)
                    System.out.println("Recv: " + msg);
            } catch (Exception e) {}
        }).start();

        BufferedReader kb = new BufferedReader(
            new InputStreamReader(System.in));
        while (true)
            out.println(kb.readLine());
    }
}
