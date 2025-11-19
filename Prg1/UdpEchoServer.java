import java.net.*;

public class UdpEchoServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9000);
        byte[] buffer = new byte[1024];

        System.out.println("UDP Echo Server running on port 9000...");

        while (true) {
            DatagramPacket request = new DatagramPacket(buffer, buffer.length);
            socket.receive(request);

            String message = new String(request.getData(), 0, request.getLength());
            System.out.println("Client: " + message);

            DatagramPacket response = new DatagramPacket(
                    message.getBytes(),
                    message.length(),
                    request.getAddress(),
                    request.getPort()
            );

            socket.send(response);
        }
    }
}
