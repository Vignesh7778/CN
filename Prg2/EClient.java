import java.io.*;
import java.net.*;

public class EClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 9000);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader srv = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        String line;
        while (!(line = in.readLine()).equalsIgnoreCase("end")) {
            out.println(line);
            System.out.println("Server: " + srv.readLine());
        }
        s.close();
    }
}
