package ArxivClient.Network;
import java.util.concurrent.*;

public class DownloadManager {
    private static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);


    public static void downloadNow(DownloadTask task) {
        executor.execute(task);
    }

    public static void downloadWithDelay(DownloadTask task, int delay, TimeUnit unit) {
        executor.schedule(task, delay, unit);
    }

    //TODO:: Протестить смену размера при выполнении скачивания
    public static void setPoolSize(int size) {
        executor.setCorePoolSize(size);
    }

    public static void closePoolsOnFinish() {
        int activeTask = 1;
        while(activeTask>0) {
            activeTask = executor.getActiveCount();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}

