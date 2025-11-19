import java.net.*;

public class UdpSimpleClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");

        String msg = "Hello, world!";
        DatagramPacket p =
            new DatagramPacket(msg.getBytes(), msg.length(), ip, 9001);
            System.out.println("Sent: " + msg);

        ds.send(p);
    }
}
