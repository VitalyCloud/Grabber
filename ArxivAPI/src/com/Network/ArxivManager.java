package com.Network;

import com.Network.Article.Article;
import com.Network.Parser.ResponseParser;
import com.Network.Search.Parameters.Field.Field;
import com.Network.Search.SearchRequest;

import javax.swing.text.html.parser.Parser;
import java.io.File;
import java.net.URL;
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
