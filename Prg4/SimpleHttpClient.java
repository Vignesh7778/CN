import java.io.*;
import java.net.*;

public class SimpleHttpClient {
    public static void main(String[] args) throws Exception {

        Socket s = new Socket("example.com", 80);

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println("GET / HTTP/1.0");
        out.println("Host: example.com");
        out.println();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));

        PrintWriter file = new PrintWriter("page.html");
        String line;

        while ((line = in.readLine()) != null)
            file.println(line);

        file.close();
        s.close();

        System.out.println("Saved: page.html");
    }
}

