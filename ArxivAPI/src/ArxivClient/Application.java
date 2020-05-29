package ArxivClient;

import ArxivClient.Network.DownloadManager;
import ArxivClient.UI.ViewLoader;;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.prefs.Preferences;

public class Application extends javafx.application.Application {

    private static Stage mainStage;
    private static Preferences preferences;

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        preferences = Preferences.userRoot();
        Parent root = ViewLoader.load("MainView.fxml");
        stage.setTitle("MainView");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();

        //Config downloadPoolSize
        String poolSize = preferences.get("downloadPoolSize", "1");
        poolSize.replace(";", "");
        DownloadManager.setPoolSize(Integer.valueOf(poolSize));
    }

    public static Stage getMainStage() {
        return mainStage;
    }

    public static Preferences getPreferences() {
        return preferences;
    }
}
