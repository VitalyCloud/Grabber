package com;

import com.ArxivAPI.Article.Article;
import com.ArxivAPI.ArxivManager;
import com.ArxivAPI.Search.Field.BoolFlag;
import com.ArxivAPI.Search.Field.Field;
import com.ArxivAPI.Search.Parameters.MaxResult;
import com.ArxivAPI.Search.Parameters.SearchQuery;
import com.ArxivAPI.Search.SearchRequest;
import com.ArxivAPI.Handlers.SearchCompletion;
import com.FileManager.FileManager;
import com.Network.DownloadManager;
import com.Network.DownloadTask;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Testing {

    static ArxivManager arxivManager = new ArxivManager();

    public static void Search() {

        Field field = new Field();
        field.addAll("dog", BoolFlag.UNDEFINED);

        SearchQuery searchQuery = new SearchQuery(field);

        SearchRequest searchRequest = new SearchRequest(searchQuery);
        searchRequest.setMaxResult(new MaxResult(3));

        arxivManager.search(searchRequest, new SearchCompletion() {
            @Override
            public void completion(ArrayList<Article> data, Throwable error) {
                if(data!=null) {
                    for(Article article: data)
                        article.print();
                } else {
                    System.out.println("Handle Errors:");
                    error.printStackTrace();
                }
            }
        });

        try {Thread.sleep(2000);}
        catch (Exception ex) {ex.printStackTrace();}

//        CompletableFuture<ArrayList<Article>> futureResult = arxivManager.search(searchRequest);
//        futureResult.thenAccept( articles -> {
//            for(Article article: articles) {
//                article.print();
//            }
//
//        }).exceptionally( error -> {
//            error.printStackTrace();
//            return null;
//        });
//
//        try {
//            futureResult.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }

    


    public static void Download() {

        URL url = null;
        String filePath = "/Users/vitalycloud/Desktop/";

        String fileName1 = "test1.pdf";
        String fileName2 = "test2.pdf";

        File file1 = FileManager.createNewFile(filePath+fileName1);
        File file2 = FileManager.createNewFile(filePath+fileName2);

        try {
            url = new URL("http://arxiv.org/pdf/1912.00839v1");
        } catch (Exception ex) {}
        
        DownloadTask newDownload = new DownloadTask(url, file1, (file, error) -> {
            if(error==null) {
                System.out.println("Downloading " + file.getName() + " completed Successful");
            } else {
                System.out.println("Downloading " + file.getName() + " completed with error");
                error.printStackTrace();
            }
        });


        DownloadTask anotherDownload = new DownloadTask(url, file2, (file, error) -> {
            if(error==null) {
                System.out.println("Downloading " + file.getName() + " completed Successful");
            } else {
                System.out.println("Downloading " + file.getName() + " completed with error");
                error.printStackTrace();
            }
        });

        DownloadManager manager = new DownloadManager(10);
        manager.downloadNow(newDownload);


    }

}
