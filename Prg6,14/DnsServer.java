import java.net.*;

public class DnsServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(9003);

        byte[] buf = new byte[100];
        DatagramPacket p = new DatagramPacket(buf, buf.length);

        while (true) {
            ds.receive(p);
            String q = new String(buf, 0, p.getLength());

            String reply = q.equals("google.com")
                          ? "142.250.72.14"
                          : "NOT FOUND";

            DatagramPacket r = new DatagramPacket(
                    reply.getBytes(), reply.length(),
                    p.getAddress(), p.getPort());

            ds.send(r);
        }
    }
}
