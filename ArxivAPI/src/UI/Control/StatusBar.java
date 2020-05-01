package UI.Control;

import UI.Stylesheet.StyleSheet;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


public class StatusBar {

    HBox pane;


    public StatusBar() {
        super();
        pane = new HBox();
        pane.getStylesheets().add(StyleSheet.get());
        pane.getStyleClass().add("status-bar");
    }

    private void config() {

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
