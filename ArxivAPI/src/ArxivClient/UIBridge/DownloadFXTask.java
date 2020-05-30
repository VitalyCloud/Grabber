package ArxivClient.UIBridge;


import ArxivClient.Network.Download.DownloadConnection;


import ArxivClient.UI.ResultView.ArticleResultModel;

import javafx.concurrent.Task;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class DownloadFXTask extends Task<File> {

    private ArticleResultModel article;
    private ArticleFileCreator articleFileCreator;

    private File file;

    public DownloadFXTask(ArticleResultModel article) {
        this.article = article;
        this.articleFileCreator = new ArticleFileCreator();
    }

    private FileOutputStream fileOutputStream;
    private HttpsURLConnection downloadConnection;
    private BufferedInputStream bufferedInputStream;

    @Override
    protected File call() throws Exception {
        file = articleFileCreator.create(article);
        URL url = new URL(article.getLinkToPDF());

        //Set https protocol
        //Если не использовать https, то openConnection() виснет и ничего не происходит
        URL newUrl = new URL("https", url.getHost(), url.getPort(), url.getFile());

        //Log
        System.out.println("Start downloading from: " + newUrl.toString());

        //Configuration connection
        downloadConnection = (HttpsURLConnection) DownloadConnection.openConnection(newUrl);
        downloadConnection.setRequestMethod("GET");
        downloadConnection.setDoOutput(true);

        //Creating Buffers
        bufferedInputStream = new BufferedInputStream(downloadConnection.getInputStream());
        fileOutputStream = new FileOutputStream(file);

        //For progress
        double fileSize = (double)downloadConnection.getContentLength();
        double downloaded = 0.00;
        double percentDownloaded = 0.00;
        int len = 0;

        byte[] buff = new byte[1024];
        len=bufferedInputStream.read(buff);
        while(len!=-1) {
            fileOutputStream.write(buff);
            len = bufferedInputStream.read(buff);

            //Calculate percent of download
            downloaded += len;
            percentDownloaded = (downloaded*100)/fileSize;

            updateProgress(percentDownloaded, 100);
        }

        fileOutputStream.flush();
        bufferedInputStream.close();
        fileOutputStream.close();
        downloadConnection.disconnect();

        return file;
    }

    @Override
    protected void succeeded() {
        super.succeeded();
        updateProgress(100, 100);
    }

    @Override
    protected void cancelled() {
        super.cancelled();
        if(bufferedInputStream!= null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(downloadConnection!=null)
            downloadConnection.disconnect();
        if(fileOutputStream!=null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        file.delete();
        System.out.println("Task was Canceled:" + article.getTitle());
    }

    public ArticleResultModel getArticle() {
        return article;
    }
}
