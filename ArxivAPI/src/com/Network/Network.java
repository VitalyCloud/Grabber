package com.Network;

import com.Network.Iterfaces.Request;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class Network {
    HttpClient client;
    DownloadManager downloadManager;

    public Network() {
        client = HttpClient.newHttpClient();
        downloadManager = new DownloadManager(1);
    }

    public CompletableFuture<HttpResponse<String>> sendGETRequest(Request newRequest) {
        URI uri = URI.create(newRequest.getAbsoluteString());
        HttpRequest httpRequest = HttpRequest.newBuilder(uri)
                .GET()
                .timeout(Duration.ofSeconds(20))
                .build();
        return client.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public CompletableFuture<Integer> downloadFile(URL url, File file) {


        return null;
    }

    public DownloadManager getDownloadManager() {
        return downloadManager;
    }
}
