import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpUCDemo {
    public static void main(String[] args) throws Exception{
        URL url = URI.create("https://www.google.com").toURL();

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        System.out.println("Request method: " + conn.getRequestMethod());

        System.out.println("Response code: " + conn.getResponseCode());

        System.out.println("Response message: " + conn.getResponseMessage());

        // list of the header fields
        Map<String, List<String>> headers = conn.getHeaderFields();

        // header keys
        Set<String> keys = headers.keySet();

        System.out.println("Header:");
        for(String key : keys) {
            System.out.println(key + ": " + headers.get(key));
        }
    }
}
