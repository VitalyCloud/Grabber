package ArxivClient.UI.MainView;

import java.net.URL;
import java.util.ResourceBundle;


import ArxivClient.UI.DownloadView.DownloadView;
import ArxivClient.UI.ResultView.ResultView;
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

    private static SearchView searchView;
    private static DownloadView downloadView;


    @FXML
    void initialize() {

        searchView = new SearchView();
        downloadView = new DownloadView();

        searchButton.setOnAction(e-> {
            mainPane.setCenter(searchView);
        });

        downloadsButton.setOnAction(e-> {
            mainPane.setCenter(downloadView);
        });

        mainPane.setCenter(searchView);
    }

    public static DownloadView getDownloadView() {
        return downloadView;
    }

    public static SearchView getSearchView() {
        return searchView;
    }
}
