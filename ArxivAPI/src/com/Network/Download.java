package com.Network;

import java.io.File;
import java.io.*;
import java.net.*;

@Deprecated
public class Download implements Runnable {

    protected String linkString;
    protected File out;

    public Download(String link, File out) {
        this.linkString = link;
        this.out = out;
    }

    @Override
    public void run() {
        try {
            //Set https protocol
            URL oldUrl = new URL(linkString);
            URL newUrl = new URL("https", oldUrl.getHost(), oldUrl.getPort(), oldUrl.getFile());
            System.out.println("Download from: " + newUrl.toString());

            HttpURLConnection conn = (HttpURLConnection) newUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(10000);
            BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
            FileOutputStream out = new FileOutputStream(this.out);

            //For download progress
            double fileSize = (double)conn.getContentLength();
            double downloaded = 0.00;
            double percentDownloaded = 0.00;

            int len=0;
            byte[] buff = new byte[1024];
            len=in.read(buff);
            while(len!=-1) {
                out.write(buff);
                len=in.read(buff);

                //Calculate percent of download
                downloaded += len;
                percentDownloaded = (downloaded*100)/fileSize;
                String percent = String.format("%.4f", percentDownloaded);
                //TODO: Notify about progress
//                System.out.println("Downloaded " + percent + "% of file.");
            }

            out.flush();
            in.close();
            out.close();
        } catch (MalformedURLException ex) {
            System.out.println("Error while creating URL");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void perform(String url, File out) {
        Thread newThread = new Thread(new Download(url,out));
        newThread.start();
    }

}
