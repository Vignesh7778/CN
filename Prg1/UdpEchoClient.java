import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the msg:");
        String msg = scan.nextLine();
        
        byte[] data = msg.getBytes();

        DatagramPacket packet = new DatagramPacket(data, data.length, ip, 9000);
        socket.send(packet);

        byte[] buf = new byte[1024];
        DatagramPacket reply = new DatagramPacket(buf, buf.length);
        socket.receive(reply);

        String response = new String(reply.getData(), 0, reply.getLength());
        System.out.println("Server replied: " + response);

        socket.close();
    }
}
