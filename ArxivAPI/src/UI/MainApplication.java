package UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class MainApplication extends Application {

    final int WindowWidth = 1439;
    final int WindowHeight = 931;
    final String WindowName = "Grabber";


    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle(WindowName);

        MainWindow window = new MainWindow();
        window.config();

        Scene scene = new Scene(window, WindowWidth, WindowHeight);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
