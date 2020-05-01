package UI.Control;

import UI.Factories.ButtonFactory;
import UI.Stylesheet.StyleSheet;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MenuBar {

    VBox pane;

    Button searchButton;
    Button downloadButton;
    Button settingsButton;

    public MenuBar() {
        super();
        pane = new VBox();

        searchButton = ButtonFactory.menuButton("Search");
        downloadButton = ButtonFactory.menuButton("Download");
        settingsButton = ButtonFactory.menuButton("Settings");

        pane.getStylesheets().add(StyleSheet.get());
        pane.getStyleClass().add("menu-bar");
    }

    private void config() {

        HBox searchButtonLayout = new HBox();
        HBox downloadButtonLayout = new HBox();
        HBox settingsButtonLayout = new HBox();

        searchButtonLayout.getChildren().add(searchButton);
        downloadButtonLayout.getChildren().add(downloadButton);
        settingsButtonLayout.getChildren().add(settingsButton);

        pane.getChildren().add(searchButtonLayout);
        pane.getChildren().add(downloadButtonLayout);
        pane.getChildren().add(settingsButtonLayout);
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
