import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket soc = null;
        BufferedImage img = null;

        try {
            // Connect to server
            soc = new Socket("localhost", 4000);
            System.out.println("Client is running.");

            // Read image from disk
            System.out.println("Reading image from disk...");
            img = ImageIO.read(new File("car.jpeg"));

            // Convert image to byte array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", baos);
            baos.flush();
            byte[] bytes = baos.toByteArray();
            baos.close();

            // Send image to server
            System.out.println("Sending image to server...");
            OutputStream out = soc.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);

            dos.writeInt(bytes.length); // send length first
            dos.write(bytes, 0, bytes.length); // then send the image data
            System.out.println("Image sent to server.");

            dos.close();
            out.close();
            soc.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            if (soc != null) soc.close();
        }
    }
}
