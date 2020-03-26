package com;

import com.ArxivAPI.Article.Article;
import com.ArxivAPI.ArxivManager;
import com.Network.Download;
import com.ArxivAPI.Search.Parameters.Field.BoolFlag;
import com.ArxivAPI.Search.Parameters.Field.Field;
import com.ArxivAPI.Search.Parameters.MaxResult;
import com.ArxivAPI.Search.Parameters.SearchQuery;
import com.ArxivAPI.Search.SearchRequest;

import java.io.File;
import java.util.ArrayList;

public class Testing {

    public static void Field() {

        Field field = new Field();
        field.addAll("math", BoolFlag.UNDEFINED);


        SearchQuery searchQuery = new SearchQuery(field);

        SearchRequest searchRequest = new SearchRequest(searchQuery);
        searchRequest.setMaxResult(new MaxResult(100));

        ArxivManager arxivManager = new ArxivManager();
        try {
            ArrayList<Article> result = arxivManager.search(searchRequest);
            System.out.println("Result count: " + result.size());
            for (Article article: result) {
//                article.print();

                File file = new File("/Users/vitalycloud/Desktop/ArxivDownloads/" +
                        article.getTitle() + ".pdf");

                Download.perform(article.getLinkToPDF(), file);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
