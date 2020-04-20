package com.Network;
import java.util.concurrent.*;

public class DownloadManager {
    ScheduledThreadPoolExecutor executor;

    public DownloadManager(int poolSize) {
        this.executor= new ScheduledThreadPoolExecutor(poolSize);
    }

    public void downloadNow(DownloadTask task) {
        executor.execute(task);
    }

    public void downloadWithDelay(DownloadTask task, int delay, TimeUnit unit) {
        executor.schedule(task, delay, unit);
    }

    //TODO:: Протестить смену размера при выполнении скачивания
    public void setPoolSize(int size) {
        executor.setCorePoolSize(size);
    }
}

