package com.Network.Iterfaces.Handlers;

import java.io.File;
import java.io.IOException;

public interface DownloadTaskCompletion {
    public void complete(File file, Exception error);
}
