package UI.Search;

import UI.Stylesheet.StyleSheet;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;



public class SearchWindow  {

    VBox vbox;
    private SearchRowKeeper rowKeeper;
    private SearchButtonRow searchButtonRow;

    BorderPane pane;

    public SearchWindow() {

        pane = new BorderPane();
        vbox = new VBox();
        rowKeeper = new SearchRowKeeper(vbox);
        searchButtonRow = new SearchButtonRow();


        vbox.getStylesheets().add(StyleSheet.get());
        vbox.getStyleClass().add("search-window");
        pane.getStylesheets().add(StyleSheet.get());
        pane.getStyleClass().add("search-window-border-pane");;

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setContent(vbox);

        scrollPane.setStyle("-fx-focus-color: none;");

        //TODO: Удалить фокус при нажатии на Vbox

        pane.setCenter(scrollPane);
        pane.setBottom(searchButtonRow);
    }

    private void config() {
        searchButtonRow.getButton().setVisible(false);

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
