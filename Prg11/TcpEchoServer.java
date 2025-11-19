import java.net.*;
import java.io.*;

public class TcpEchoServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(9005);

        while (true) {
            Socket s = ss.accept();
            new Thread(() -> {
                try {
                    BufferedReader in = new BufferedReader(
                        new InputStreamReader(s.getInputStream()));
                    PrintWriter out = new PrintWriter(s.getOutputStream(), true);

                    String msg;
                    while ((msg = in.readLine()) != null)
                        out.println(msg);
                } catch (Exception e) {}
            }).start();
        }
    }
}
