import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramDemo {
    public static int serverPort = 998;
    public static int clientPort = 999;
    public static int bufferSize = 1024;
    public static DatagramSocket socket;
    public static byte[] buf = new byte[bufferSize];

    public static void TheServer() throws Exception {
        int pos=0;
        while (true) {
            int c = System.in.read();
            switch (c) {
                case -1:
                    System.out.println("Server closed");
                    socket.close();
                    return;
                case '\r':
                    break;
                case '\n':
                    socket.send(new DatagramPacket(buf, pos, InetAddress.getLocalHost(), clientPort));
                    pos = 0;
                    break;
                default:
                    buf[pos++] = (byte) c;
            }
        }
    }

    public static void TheClient() throws Exception {
        while (true) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            System.out.println("Client received: " + new String(packet.getData(), 0, packet.getLength()));
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            socket = new DatagramSocket(serverPort);
            TheServer();
        } else {
            socket = new DatagramSocket(clientPort);
            TheClient();
        }
    }
}
