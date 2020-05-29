package ArxivClient;

import ArxivClient.ArxivAPI.Article.Article;
import ArxivClient.ArxivAPI.Field.BoolFlag;
import ArxivClient.ArxivAPI.Field.SearchField;
import ArxivClient.ArxivAPI.Prefix.PrefixFactory;
import ArxivClient.ArxivAPI.SearchRequest;
import ArxivClient.FileManager.FileDescriber;
import ArxivClient.FileManager.FileExtension;
import ArxivClient.ArxivAPI.ArxivManager;
import ArxivClient.FileManager.FileManager;
import ArxivClient.Network.DownloadManager;
import ArxivClient.UIBridge.DownloadFXTask;
import ArxivClient.UIBridge.SearchArticleService;
import javafx.concurrent.Task;

import java.io.File;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Testing {

    static ArxivManager arxivManager = new ArxivManager();

//    public static void Search() {
//        SearchArticleService searchArticleService = new SearchArticleService();
//        SearchField searchField = new SearchField();
//        searchField.add(PrefixFactory.all("Math"), BoolFlag.UNDEFINED);
//        SearchRequest searchRequest = new SearchRequest(searchField);
//
//        searchArticleService.setSearchRequest(searchRequest);
//
//        searchArticleService.start();
//
////        searchArticleService.setOnSucceeded(e-> {
////            List<Article> result = searchArticleService.getValue();
////            System.out.println(result.size());
////            Download(result.get(0));
////        });
//
//        searchArticleService.setOnFailed(e -> {
//            System.out.println("Error");
//            searchArticleService.getException().printStackTrace();
//        });
//
//    }
//
//    public static void Download(Article article) {
//        String filePath = "C:\\dev\\Grabber\\Downlaods\\";
//        File file = null;
//        File file2 = null;
//        try {
//            file = FileManager.createNewFile(new FileDescriber(filePath, "Test3", FileExtension.PDF));
//            file2 = FileManager.createNewFile(new FileDescriber(filePath, "Test4", FileExtension.PDF));
//        } catch (FileAlreadyExistsException e) {
//            e.printStackTrace();
//        }
//
//        Task<File> downlaodTask = new DownloadFXTask(article, file);
//        Task<File> downloadTask2 = new DownloadFXTask(article, file2);
//
//        downlaodTask.setOnSucceeded(e -> {
//            File outfile = downlaodTask.getValue();
//            System.out.println("Download Complete: " + outfile.getAbsolutePath());
//        });
//
//        downloadTask2.setOnSucceeded(e -> {
//            File outfile = downloadTask2.getValue();
//            System.out.println("Download Complete: " + outfile.getAbsolutePath());
//        });
//
//        DownloadManager.setPoolSize(2);
//        DownloadManager.downloadNow(downlaodTask);
//        DownloadManager.downloadWithDelay(downloadTask2, 3, TimeUnit.SECONDS);
//
//    }

}
