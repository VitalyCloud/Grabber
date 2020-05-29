package ArxivClient.UIBridge;

import ArxivClient.Application;
import ArxivClient.ArxivAPI.Article.Article;
import ArxivClient.FileManager.FileDescriber;
import ArxivClient.FileManager.FileExtension;
import ArxivClient.FileManager.FileManager;

import java.io.File;
import java.io.IOException;

public class ArticleFileCreator {

    private static String directory = "";

    public ArticleFileCreator() {
        String directory = Application.getPreferences().get("downloadDirectory", "");
        updateDirectory(directory);
    }

    public ArticleFileCreator(String directory) {
        this();
        this.directory = directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getDirectory() {
        return directory;
    }

    public File create(Article article) throws IOException {
        File outFile = null;

        String id = article.getId();
        System.out.println("ID: " + id);
        int lastIndex = id.lastIndexOf("/");
        System.out.println("Last \\ index - " + String.valueOf(lastIndex));
        String fileName = id.substring(lastIndex, id.length());

        FileDescriber fileDescriber = new FileDescriber(directory, fileName, FileExtension.PDF);

        outFile = FileManager.createNewFile(fileDescriber, true);
        return outFile;
    }

    public static void updateDirectory(String path) {
        path.replaceFirst(";", File.pathSeparator);
        directory = path;
    }
}
