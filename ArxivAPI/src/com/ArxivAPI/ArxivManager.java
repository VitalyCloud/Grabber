package com.ArxivAPI;

import com.ArxivAPI.Article.Article;
import com.ArxivAPI.Parser.Exceptions.JDKParserException;
import com.ArxivAPI.Parser.Exceptions.ParseException;
import com.ArxivAPI.Parser.Exceptions.RequestError;
import com.ArxivAPI.Parser.ResponseParser;
import com.ArxivAPI.Search.SearchRequest;
import com.Network.Download;
import com.Network.Network;
import com.Network.NetworkSession;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class ArxivManager {
    private NetworkSession networkSession;
    private Download download;
    private ResponseParser parser;



    public ArxivManager() {
        networkSession = new NetworkSession();
        parser = new ResponseParser();
    }

    //Find the articles
    public CompletableFuture<ArrayList<Article>> search(SearchRequest searchRequest)  {
        //TODO: Add exceptions to handle posible errors
        //TODO: Implement
//        String response = networkSession.makeURLGETRequest(searchRequest);
////        parser.parseSearchRequest(response);
////        return parser.getArticles();

        //v2.0

        Network network = new Network();

        CompletableFuture<HttpResponse<String>> futureResponse = network.sendRequest(searchRequest);
        CompletableFuture<ArrayList<Article>> futureParsedResponse = futureResponse.thenApply((response) -> {
            parser.parseSearchRequest(response.body());
            return parser.getArticles();
        });
        return futureParsedResponse;
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

    /* --Getters And Setters-- */
    public NetworkSession getNetworkSession() {
        return networkSession;
    }

    public void setNetworkSession(NetworkSession networkSession) {
        this.networkSession = networkSession;
    }

    public Download getDownload() {
        return download;
    }

    public void setDownload(Download download) {
        this.download = download;
    }

    public ResponseParser getParser() {
        return parser;
    }

    public void setParser(ResponseParser parser) {
        this.parser = parser;
    }


    /* ------------------------ */
}
