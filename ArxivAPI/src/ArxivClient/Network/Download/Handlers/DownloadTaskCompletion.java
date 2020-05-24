package ArxivClient.Network.Download.Handlers;

import java.io.File;

public interface DownloadTaskCompletion {
    public void complete(File file, Exception error);
}
