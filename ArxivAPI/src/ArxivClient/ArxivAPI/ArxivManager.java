package ArxivClient.ArxivAPI;

import ArxivClient.ArxivAPI.Article.Article;
import ArxivClient.ArxivAPI.Parser.ResponseParser;
import ArxivClient.Network.Network;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class ArxivManager {
    private ResponseParser parser;
    private Network network;

    public ArxivManager() {
        parser = new ResponseParser();
        network = new Network();
    }

    //Find the articles
    public CompletableFuture<ArrayList<Article>> search(SearchRequest searchRequest)  {
        CompletableFuture<HttpResponse<String>> futureResponse = network.sendGETRequest(searchRequest);
        CompletableFuture<ArrayList<Article>> futureParsedResponse = futureResponse.thenApply((response) -> {
            parser.parseSearchRequest(response.body());
            return parser.getArticles();
        });

        return futureParsedResponse;
    }
}
