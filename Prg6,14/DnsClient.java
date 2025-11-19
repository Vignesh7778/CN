import java.net.*;

public class DnsClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");

        DatagramPacket p =
            new DatagramPacket("google.com".getBytes(), 10, ip, 9003);
        ds.send(p);

        byte[] buf = new byte[50];
        DatagramPacket r = new DatagramPacket(buf, buf.length);
        ds.receive(r);

        System.out.println("IP = " + new String(buf, 0, r.getLength()));
    }
}
