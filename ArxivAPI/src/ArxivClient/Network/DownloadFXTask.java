package ArxivClient.Network;

import ArxivClient.ArxivAPI.Article.Article;
import ArxivClient.Network.Download.DownloadTask;

import javafx.concurrent.Task;

import java.io.File;
import java.net.URL;

public class DownloadFXTask extends Task<File> {

    File file;
    Article article;

    public DownloadFXTask(Article article, File file) {
        this.file = file;
        this.article = article;
    }

    @Override
    protected File call() throws Exception {
        URL url = new URL(article.getLinkToPDF());

        DownloadTask downloadTask = new DownloadTask(url, file);
        downloadTask.setProgressUpdate((progress) -> {
            this.updateProgress(progress, 100);
        });
        File downloadedFile = downloadTask.download();
        return downloadedFile;
    }
}
