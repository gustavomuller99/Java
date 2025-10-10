import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlDemo {
    public static void main(String[] args)  throws URISyntaxException, MalformedURLException {
        URL url = new URL("https://en.wikipedia.org:443/wiki/Java");

        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getPath());
        System.out.println(url.toExternalForm());
    }
}
