package com.ArxivAPI;

import com.ArxivAPI.Article.Article;
import com.ArxivAPI.Handlers.SearchCompletion;
import com.ArxivAPI.Parser.ResponseParser;
import com.ArxivAPI.Search.SearchRequest;
import com.FileManager.FileDescriber;
import com.FileManager.FileManager;
import com.Network.DownloadManager;
import com.Network.DownloadTask;
import com.Network.Iterfaces.Handlers.DownloadTaskCompletion;
import com.Network.Network;

import java.io.File;
import java.net.URL;
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

        futureParsedResponse.handle((articles, error) -> {
            searchCompletion.complete(articles, error);
            return articles;
        });
    }

    //Download article
    public void download(Article article, FileDescriber describer, DownloadTaskCompletion completion) {
        URL url = null;
        File file = null;

        try {
            url = new URL(article.getLinkToPDF());
            file = FileManager.createNewFile(describer);
        } catch (Exception ex) {
            completion.complete(null, ex);
        }

        DownloadTask task = new DownloadTask(url, file, completion);
        DownloadManager.downloadNow(task);

        //TODO: Add exceptions to handle posible errors
        //TODO: Implement
    }
}
