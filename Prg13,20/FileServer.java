import java.net.*;
import java.io.*;

public class FileServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(9007);
        Socket s = ss.accept();

        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));
        String fname = in.readLine();

        FileInputStream f = new FileInputStream(fname);
        OutputStream out = s.getOutputStream();

        int ch;
        while ((ch = f.read()) != -1)
            out.write(ch);

        f.close();
        s.close();
    }
}
