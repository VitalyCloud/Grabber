package ArxivClient.UI.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import ArxivClient.UI.SearchView.SearchView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane mainPane;

    @FXML
    private Button searchButton;

    @FXML
    private Button downloadsButton;

    @FXML
    private Button settingsButton;


    @FXML
    void initialize() {

        searchButton.setOnAction(e-> {
            mainPane.setCenter(new SearchView());
        });


    }
}
