package ArxivClient.FileManager;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class FileManager {

    public static File createNewFile(FileDescriber describer, boolean forceFlag) throws IOException {
        File file = new File(describer.getAbsolutePath());
        if(file.exists()) {
            if(forceFlag) {
                file.delete();
                file.createNewFile();
                return file;
            } else {
                throw new FileAlreadyExistsException("File " + describer.getAbsolutePath() + " is already exist");
            }
        }
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
