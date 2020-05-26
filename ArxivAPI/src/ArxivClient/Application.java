package ArxivClient;

import ArxivClient.UI.ViewLoader;;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = ViewLoader.load("MainView.fxml");
        stage.setTitle("MainView");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
//        Testing.Search();
    }
}
