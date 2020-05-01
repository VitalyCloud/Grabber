package UI.SearchResultWindow;

import UI.Stylesheet.StyleSheet;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class SearchResultWindow {

    VBox pane;

    SearchResultKeeper searchResultKeeper;

    public SearchResultWindow() {
        pane = new VBox();
        searchResultKeeper = new SearchResultKeeper(pane);
        pane.getStylesheets().add(StyleSheet.get());
        pane.getStyleClass().add("search-result-window");


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
