package ArxivClient.Network;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;


// Get запросы
public class Network {
    HttpClient client;

    public Network() {
        client = HttpClient.newHttpClient();
    }

    public CompletableFuture<HttpResponse<String>> sendGETRequest(Request newRequest) {
        URI uri = URI.create(newRequest.getAbsoluteString());
        HttpRequest httpRequest = HttpRequest.newBuilder(uri)
                .GET()
                .timeout(Duration.ofSeconds(20))
                .build();
        return client.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }
}
