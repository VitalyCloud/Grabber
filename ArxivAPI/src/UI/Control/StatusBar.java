package UI.Control;

import UI.MainApplication;
import UI.MainWindow;
import UI.Stylesheet.StyleSheet;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;



public class StatusBar {

    HBox pane;
    Button returnButton;

    public StatusBar() {
        super();
        pane = new HBox();
        returnButton = new Button();
        pane.getStylesheets().add(StyleSheet.get());
        pane.getStyleClass().add("status-bar");
        pane.getChildren().add(returnButton);

    }

    private void config() {
        returnButton.setVisible(false);
        returnButton.setOnAction(e-> {
            MainWindow.INSTANCE.showSearchWindow();
        });
    }

    public void showReturnButton() {
        returnButton.setVisible(true);

    }

    boolean isConfigured = false;
    public Pane getPane() {
        if(isConfigured == false) {
            config();
            isConfigured = true;
        }
        return pane;
    }
}
