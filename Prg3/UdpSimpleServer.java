import java.net.*;

public class UdpSimpleServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(9001);
        byte[] buf = new byte[100];
        DatagramPacket p = new DatagramPacket(buf, buf.length);

        ds.receive(p);
        String msg=new String(buf, 0, p.getLength());
        System.out.println("Received: " + msg);
    }
}
