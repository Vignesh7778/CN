import java.io.*;
import java.net.*;

public class EServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(9000);
        Socket s = ss.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        String line;
        while ((line = in.readLine()) != null) out.println(line);
    }
}
