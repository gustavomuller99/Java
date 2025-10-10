import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpClientDemo {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(new URI("https://www.google.com")).build();

        HttpResponse<InputStream> response = client.send(request,
                HttpResponse.BodyHandlers.ofInputStream());

        System.out.println("response code: " + response.statusCode());
        System.out.println("request method: " + request.method());

        HttpHeaders headers = response.headers();

        Map<String, List<String>> headersMap = headers.map();
        Set<String> keys = headersMap.keySet();

        System.out.println("headers:");
        for (String key : keys) {
            System.out.println(key + ": " + headersMap.get(key));
        }

        System.out.println("body:");
        InputStream inputStream = response.body();
        int c;
        while ((c = inputStream.read()) != -1) {
            System.out.print((char) c);
        }

        HttpResponse<String> response2 = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("\nbody2: " + response2.body());
    }
}
