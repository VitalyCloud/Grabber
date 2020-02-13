package com.Network;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ArxivManager {

    public static void makeRequest(String query) {
//        String query = "http://export.arxiv.org/api/query?search_query=all:electron&start=0&max_results=1";

        HttpURLConnection connection = null;

        try {

            connection = (HttpURLConnection) new URL(query).openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);

            //выполнение запроса
            connection.connect();

            StringBuilder sb = new StringBuilder();

            if(HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while((line = in.readLine()) != null){
                    sb.append(line);
                    sb.append("\n");
                }
                System.out.println(sb.toString());
            } else {
                System.out.println("fail: " + connection.getResponseCode() + ". " + connection.getResponseMessage());
            }


        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }
    }

    public static void downloadPDF(String url, String fileName, String filePath) {
        if(filePath.isEmpty()) {
            filePath = "/Users/vitalycloud/Downloads";
        }
        File out = new File(filePath+fileName+".pdf");
        new Thread(new Download(url,out)).start();
    }

}
