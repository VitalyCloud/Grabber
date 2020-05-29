package ArxivClient.Network.Download;

import ArxivClient.Network.Download.Handlers.DownloadTaskProgressUpdate;
import ArxivClient.Network.Download.Handlers.DownloadTaskCompletion;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class DownloadTask {

    private URL url;
    private File file;

    private DownloadTaskProgressUpdate progress;

    public DownloadTask(URL url, File file) {
        this.url = url;
        this.file = file;
        //TODO: Не используется прокси
    }

    public File download() throws IOException {
        //Set https protocol
        //Если не использовать https, то openConnection() виснет и ничего не происходит
        URL newUrl = new URL("https", url.getHost(), url.getPort(), url.getFile());

        //Log
        System.out.println("Start downloading from: " + newUrl.toString());

        //Configuration connection
        HttpsURLConnection conn = (HttpsURLConnection) DownloadConnection.openConnection(newUrl);
        conn.setRequestMethod("GET");
        conn.setDoOutput(true);

        //Creating Buffers
        BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
        FileOutputStream out = new FileOutputStream(file);

        //For progress
        double fileSize = (double)conn.getContentLength();
        double downloaded = 0.00;
        double percentDownloaded = 0.00;
        int len = 0;

        byte[] buff = new byte[1024];
        len=in.read(buff);
        while(len!=-1) {
            out.write(buff);
            len = in.read(buff);

            //Calculate percent of download
            downloaded += len;
            percentDownloaded = (downloaded*100)/fileSize;

            if(progress !=null) {
                progress.update(percentDownloaded);
            }
        }

        out.flush();
        in.close();
        out.close();
        conn.disconnect();

        return file;
    }

    public void setProgressUpdate(DownloadTaskProgressUpdate progress) {
        this.progress = progress;
    }
}
