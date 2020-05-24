package ArxivClient.Tutorials;


import java.io.File;
import java.nio.file.Path;

public class IO {


    public static void main(String[] args) {

    }

    public static void oldStyleFile() {
        File file = new File("/usr/bin/java");
        file.isAbsolute(); //   true
        file.getPath(); //      "/usr/bin/java"
        file.getName(); //      "java"
        file.getParent(); //    "/usr/bin"

        //File as file
        file.exists();
        file.isFile();
        file.canRead();
        file.length();
        file.lastModified();

        //File as directory
        File dir = new File("/usr/bin");
        dir.exists();
        dir.isDirectory();
        dir.list();
        dir.listFiles();

        File newFile = new File("/usr/bin/java");

        //newFile.createNewFile();
        newFile.delete();
//        newFile.renameTo(); //Перенос файла
        newFile.mkdir(); //создаст несуществующую директорию на основе пути
        newFile.mkdirs(); //создает несуществующие директории на основе пути пока не доберется до конца

    }

}
