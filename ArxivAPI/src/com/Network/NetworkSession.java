package com.Network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

@Deprecated
public class NetworkSession {

    public NetworkSession() {}

    public String makeURLGETRequest(Request request) {
        HttpURLConnection connection = null;
        String response = "";
        int responseCode = -1;
        try {
            connection = (HttpURLConnection) request.getUrl().openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(10000);

            //выполнение запроса
            connection.connect();

            if(HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                response = responseToString(connection.getInputStream());
            } else {
                System.out.println("fail: " + connection.getResponseCode() + ". " + connection.getResponseMessage());
            }
            responseCode = connection.getResponseCode();

        } catch (Exception cause) {
            cause.printStackTrace();
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }
        return response;
    }

    private static String responseToString(InputStream is) {
        StringBuilder sb = new StringBuilder();
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader in = new BufferedReader(reader);
        String line;

        try {
            while((line = in.readLine()) != null){
                sb.append(line);
                sb.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
