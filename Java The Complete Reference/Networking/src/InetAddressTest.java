import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);


        address = InetAddress.getByName("www.google.com");
        System.out.println(address);

        InetAddress[] addresses = InetAddress.getAllByName("www.nba.com");
        for (InetAddress address1 : addresses) {
            System.out.println(address1);
        }
    }
}