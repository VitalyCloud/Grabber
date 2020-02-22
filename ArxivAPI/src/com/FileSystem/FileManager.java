package com.FileSystem;

import java.io.*;

public class FileManager {

    public static File createNewFile(String pathName, boolean force) {

        File file = new File(pathName);
        return file;
    }

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
