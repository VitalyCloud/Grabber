package com.Network;

import com.Network.Iterfaces.Handlers.DownloadTaskCompletion;
import com.Network.Iterfaces.Handlers.DownloadTaskProgressUpdate;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class DownloadTask implements Runnable {

    private URL url;
    private File file;
    private DownloadTaskCompletion downloadCompletion;
    private DownloadTaskProgressUpdate progress;
    private ConnectionManager connectionManager;

    public DownloadTask(URL url, File file, DownloadTaskCompletion downloadCompletion) {
        this.url = url;
        this.file = file;
        setDownloadCompletion(downloadCompletion);
        connectionManager = new ConnectionManager();
    }

    public void setProgressUpdate(DownloadTaskProgressUpdate progress) {
        this.progress = progress;
    }
    public void setDownloadCompletion(DownloadTaskCompletion downloadCompletion) {
        this.downloadCompletion = downloadCompletion;
    }

    public void download() {
        try {
            //Set https protocol
            //Если не использовать https, то openConnection() виснет и ничего не происходит
            URL newUrl = new URL("https", url.getHost(), url.getPort(), url.getFile());

            //Log
            System.out.println("Start downloading from: " + newUrl.toString());

            //Configuration connection
            HttpsURLConnection conn = (HttpsURLConnection)connectionManager.openConnection(newUrl);
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
            downloadCompletion.complete(file, null);
        } catch (IOException ex) {
//            ex.printStackTrace();
            downloadCompletion.complete(file, ex);
        }
    }

    @Override
    public void run() {
        download();
    }
}
