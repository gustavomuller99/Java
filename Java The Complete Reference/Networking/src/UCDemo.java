import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Date;

public class UCDemo {
    public static void main(String[] args) throws Exception {
        int c;
        URL hp = new URI("https://www.google.com").toURL();
        URLConnection conn = hp.openConnection();

        long d = conn.getDate();
        if (d == 0) {
            System.out.println("No date found");
        } else {
            System.out.println("Date: " + new Date(d));
        }

        System.out.println("Content-Type: " + conn.getContentType());

        d = conn.getExpiration();
        if (d == 0) {
            System.out.println("No expiration found");
        } else {
            System.out.println("Expiration: " + new Date(d));
        }

        d = conn.getLastModified();
        if (d == 0) {
            System.out.println("No last modified found");
        } else {
            System.out.println("Last modified: " + new Date(d));
        }

        d = conn.getContentLengthLong();
        if (d == -1) {
            System.out.println("No content length found");
        } else {
            System.out.println("Content length: " + d);
        }

        if (d != 0) {
            System.out.println("---Content---");
            InputStream in = conn.getInputStream();
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
            in.close();
        }
        else {
            System.out.println("No content found");
        }
    }
}
