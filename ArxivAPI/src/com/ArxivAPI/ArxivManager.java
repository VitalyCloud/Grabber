package com.ArxivAPI;

import com.ArxivAPI.Article.Article;
import com.ArxivAPI.Parser.ResponseParser;
import com.ArxivAPI.Search.SearchRequest;
import com.Network.Download;
import com.Network.NetworkSession;

import java.util.ArrayList;

public class ArxivManager {
    private NetworkSession networkSession;
    private Download download;
    private ResponseParser parser;


    public ArxivManager() {
        networkSession = new NetworkSession();
        parser = new ResponseParser();
    }

    //Find the articles
    public ArrayList<Article> search(SearchRequest searchRequest) throws Exception {
        //TODO: Add exceptions to handle posible errors
        //TODO: Implement
        String response = networkSession.makeURLGETRequest(searchRequest);
        parser.parseSearchRequest(response);
        return parser.getArticles();
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
