import java.net.*;
import java.io.*;

public class FileClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 9007);
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        out.println("input.txt");  // file to download

        FileOutputStream f = new FileOutputStream("output.txt");
        int ch;
        while ((ch = s.getInputStream().read()) != -1)
            f.write(ch);

        f.close();
        s.close();
    }
}
