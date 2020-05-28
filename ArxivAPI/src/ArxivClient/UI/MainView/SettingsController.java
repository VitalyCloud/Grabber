package ArxivClient.UI.MainView;


import java.io.File;
import java.net.Proxy;
import java.net.URL;
import java.util.ResourceBundle;

import ArxivClient.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class SettingsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text documentPath;

    @FXML
    private Button documentChooseButton;

    @FXML
    private Spinner<Integer> poolSizeSpinner;

    @FXML
    private Spinner<Integer> delaySpinner;

    public static SettingsController INSTANCE;


    @FXML
    void initialize() {
        INSTANCE = this;

        SpinnerValueFactory<Integer> poolSizeVF = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10,3);
        poolSizeSpinner.setValueFactory(poolSizeVF);

        SpinnerValueFactory<Integer> delayVF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,3);
        delaySpinner.setValueFactory(delayVF);


        //Save settings
        poolSizeVF.valueProperty().addListener((obs, oldValue, newValue) -> {
            Application.getPreferences().put("downloadPoolSize", String.valueOf(newValue));
        });

        delayVF.valueProperty().addListener((obs, oldValue, newValue) -> {
            Application.getPreferences().put("downloadDelay", String.valueOf(newValue));
        });

        //Initiate values
        String downloadDirectory = Application.getPreferences().get("downloadDirectory", "");
        documentPath.setText(downloadDirectory);

        String stringPoolSize = Application.getPreferences().get("downloadPoolSize", "3");
        Integer poolSize = Integer.valueOf(stringPoolSize);
        poolSizeVF.setValue(poolSize);

        String stringDownloadDelay = Application.getPreferences().get("downloadDelay", "0");
        Integer downloadDelay = Integer.valueOf(stringDownloadDelay);
        delayVF.setValue(downloadDelay);

        documentChooseButton.setOnAction(e -> documentChooseButtonPressed());
    }

    private void documentChooseButtonPressed() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Set download directory");
        File selectedFile = directoryChooser.showDialog(Application.getMainStage());
        if(selectedFile!=null) {
            documentPath.setText(selectedFile.getAbsolutePath());
            Application.getPreferences().put("downloadDirectory", selectedFile.getAbsolutePath());
        }
    }
}
