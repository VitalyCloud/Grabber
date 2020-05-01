package com;

import com.Network.DownloadManager;

public class Main {

    public static void main(String[] args) {
        //TODO: Implement Interface
        //TODO: Complete implementing ArxivManager and Search
        //TODO: Implement FileSystem for different os
        //TODO: Testing

//        System.getProperties().list(System.out);


        Testing.Search();

        DownloadManager.closePoolsOnFinish();
    }

}
