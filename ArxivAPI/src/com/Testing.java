package com;

import com.ArxivAPI.Article.Article;
import com.ArxivAPI.ArxivManager;
import com.ArxivAPI.Search.Field.BoolFlag;
import com.ArxivAPI.Search.Field.Field;
import com.ArxivAPI.Search.Parameters.MaxResult;
import com.ArxivAPI.Search.Parameters.SearchQuery;
import com.ArxivAPI.Search.SearchRequest;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Testing {

    public static void Search() {

        Field field = new Field();
        field.addAll("math", BoolFlag.UNDEFINED);

        SearchQuery searchQuery = new SearchQuery(field);

        SearchRequest searchRequest = new SearchRequest(searchQuery);
        searchRequest.setMaxResult(new MaxResult(3));

        ArxivManager arxivManager = new ArxivManager();

        CompletableFuture<ArrayList<Article>> futureResult = arxivManager.search(searchRequest);
        futureResult.thenAccept( articles -> {
            for(Article article: articles)
                article.print();
        }).exceptionally( error -> {
            error.printStackTrace();
            return null;
        });

        try {
            futureResult.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}
