package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileManager {

    public static String fileToString(File file) {
        try {
            StringBuilder sb = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader in = new BufferedReader(reader);
            String line;

            while((line = in.readLine()) != null){
                sb.append(line);
                sb.append("\n");
            }

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
