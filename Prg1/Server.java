import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = null;
        Socket socket;

        try {
            server = new ServerSocket(4000);
            System.out.println("Server waiting for image...");

            socket = server.accept();
            System.out.println("Client connected.");

            // Receive image data
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            int len = dis.readInt();
            System.out.println("Image Size: " + len / 1024 + " KB");

            byte[] data = new byte[len];
            dis.readFully(data);

            dis.close();
            in.close();
            socket.close();
            server.close();

            // Convert byte array back to BufferedImage
            InputStream ian = new ByteArrayInputStream(data);
            BufferedImage bImage = ImageIO.read(ian);

            // Show image in a JFrame
            JFrame f = new JFrame("Server - Received Image");
            ImageIcon icon = new ImageIcon(bImage);
            JLabel l = new JLabel();
            l.setIcon(icon);
            f.add(l);
            f.pack();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

            System.out.println("Image received and displayed.");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            if (server != null) {
                server.close();
            }
        }
    }
}
