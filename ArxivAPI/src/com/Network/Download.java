package com.Network;

import java.io.File;
import java.io.*;
import java.net.*;

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
            URL linkURL = new URL(linkString);
            HttpURLConnection http = (HttpURLConnection)linkURL.openConnection();

            //return number of bytes
            double fileSize = (double)http.getContentLength();

            BufferedInputStream in = new BufferedInputStream(http.getInputStream());
            FileOutputStream fos = new FileOutputStream(this.out);
            BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
            byte[] buffer  = new byte[1024];
            double downloaded = 0.00;
            int read = 0;
            double percentDownloaded = 0.00;
            while((read = in.read(buffer, 0,1024)) >= 0) {
                bout.write(buffer, 0, read);
                downloaded += read;
                percentDownloaded = (downloaded*100)/fileSize;
                String percent = String.format("%.4f", percentDownloaded);
                System.out.println("Downloaded " + percent + "% of file.");
            }
            bout.close();
            in.close();
            System.out.println("com.Network.Download complete");

//            //Simply way without download progress
//            URL website = new URL(link);
//            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
//            FileOutputStream fostream = new FileOutputStream(out);
//            fostream.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
