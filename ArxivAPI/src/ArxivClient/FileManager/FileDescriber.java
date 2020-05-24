package ArxivClient.FileManager;

public class FileDescriber {
    private FileExtension extension;
    private String path;
    private String name;

    public FileDescriber(String path, String name, FileExtension extension) {
        this.extension = extension;
        this.path = path;
        this.name = name;
    }

    public String getAbsolutePath() {
        return path+name+"."+extension.name().toLowerCase();
    }

    public FileExtension getExtension() {
        return extension;
    }

    public void setExtension(FileExtension extension) {
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
