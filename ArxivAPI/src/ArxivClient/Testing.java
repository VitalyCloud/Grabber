package ArxivClient;

import ArxivClient.ArxivAPI.Article.Article;
import ArxivClient.ArxivAPI.Handlers.SearchCompletion;
import ArxivClient.ArxivAPI.Search.Field.BoolFlag;
import ArxivClient.ArxivAPI.Search.Field.Field;
import ArxivClient.ArxivAPI.Search.Parameters.MaxResult;
import ArxivClient.ArxivAPI.Search.Parameters.SearchQuery;
import ArxivClient.ArxivAPI.Search.SearchRequest;
import ArxivClient.FileManager.FileDescriber;
import ArxivClient.FileManager.FileExtension;
import ArxivClient.FileManager.FileManager;
import ArxivClient.Network.DownloadManager;
import ArxivClient.Network.DownloadTask;
import ArxivClient.ArxivAPI.ArxivManager;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;


public class Testing {

    static ArxivManager arxivManager = new ArxivManager();

    public static void Search() {

        Field field = new Field();
        field.addAuthor("Akbarov", BoolFlag.UNDEFINED);

        SearchQuery searchQuery = new SearchQuery(field);

        SearchRequest searchRequest = new SearchRequest(searchQuery);
        searchRequest.setMaxResult(new MaxResult(1));

//        arxivManager.search(searchRequest, new SearchCompletion() {
//            @Override
//            public void complete(ArrayList<Article> data, Throwable error) {
//                if(data!=null) {
//                    for(Article article: data)
//                        Download(article);
//                } else {
//                    System.out.println("Handle Errors:");
//                    error.printStackTrace();
//                }
//            }
//        });

        try {Thread.sleep(10000);}
        catch (Exception ex) {ex.printStackTrace();}
    }

    public static void Download(Article article) {
        String filePath = "/Users/vitalycloud/Desktop/";
        FileDescriber describer = new FileDescriber(filePath, "Akbarov1", FileExtension.PDF);

        arxivManager.download(article, describer, (file, error) -> {
            if(error==null) {
                System.out.println("Download file "+file.getName()+ " completed Success\n" +
                        file.getAbsolutePath());
            }
            else {
                System.out.println("Download file completed with Error");
                error.printStackTrace();
            }
        });
    }


    //NOT WORKING
    public static void DownloadPNG() {
        try {
            URL url = new URL("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3Dk4p7YnbLNvY&psig=AOvVaw2mcpsOtXX6168tsnkmf9Bp&ust=1587473822625000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCIjOsIGH9-gCFQAAAAAdAAAAABAO");
            String fileName = "CharlieScene";
            String path = "/Users/vitalycloud/Desktop/";
            FileDescriber fileDescriber = new FileDescriber(path, fileName, FileExtension.PNG);
            File file = FileManager.createNewFile(fileDescriber);
            DownloadTask task = new DownloadTask(url, file, (downloadedFile, error) -> {
                if(error==null) {
                    System.out.println("File "+ file.getName() + " downloaded successful");
                } else {
                    System.out.println("File "+ file.getName() + " downloaded with error");
                    error.printStackTrace();
                }
            });

            DownloadManager.downloadNow(task);

        } catch (Exception ex) {ex.printStackTrace();}
    }
}
