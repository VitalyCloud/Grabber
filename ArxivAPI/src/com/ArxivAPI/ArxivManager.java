package com.ArxivAPI;

import com.ArxivAPI.Article.Article;
import com.ArxivAPI.Handlers.SearchCompletion;
import com.ArxivAPI.Parser.ResponseParser;
import com.ArxivAPI.Search.SearchRequest;
import com.Network.Network;

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
    public void search(SearchRequest searchRequest,
                       SearchCompletion searchCompletion)  {
        CompletableFuture<HttpResponse<String>> futureResponse = network.sendGETRequest(searchRequest);
        CompletableFuture<ArrayList<Article>> futureParsedResponse = futureResponse.thenApply((response) -> {
            parser.parseSearchRequest(response.body());
            return parser.getArticles();
        });

        futureParsedResponse.thenAccept( articles -> {
            searchCompletion.completion(articles, null);
        }).exceptionally( error -> {
            searchCompletion.completion(null, error);
            return null;
        });
    }

    //Download article
    public void download(Article article, String path) {



        //TODO: Add exceptions to handle posible errors
        //TODO: Implement
    }

    //Download many articles
    public void download(ArrayList<Article> articleList, String path) {
        //TODO: Add exceptions to handle posible errors
        //TODO: Implement
    }


    /* ------------------------ */
}
