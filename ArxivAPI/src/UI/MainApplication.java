package UI;

import ArxivClient.ArxivAPI.ArxivManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class MainApplication extends Application {

    final int WindowWidth = 1439;
    final int WindowHeight = 931;
    final String WindowName = "Grabber";
    public static ArxivManager arxivManager = new ArxivManager();
    public static MainWindow mainWindow = MainWindow.INSTANCE;


    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle(WindowName);

        mainWindow.config();
        Scene scene = new Scene(mainWindow, WindowWidth, WindowHeight);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
