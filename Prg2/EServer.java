
import java.io.*;
import java.net.*;

public class EServer {
    public static void main(String args[]) {
        ServerSocket s = null;
        String line;
        DataInputStream is;
        PrintStream ps;
        Socket c = null;

        try {
            s = new ServerSocket(9000);
            System.out.println("Server started. Waiting for client...");
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            c = s.accept();
            System.out.println("Client Connected!");

            is = new DataInputStream(c.getInputStream());
            ps = new PrintStream(c.getOutputStream());

            while (true) {
                line = is.readLine();      // receive from client
                ps.println(line);          // send back to client (echo)
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
