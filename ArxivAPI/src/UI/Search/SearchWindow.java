package UI.Search;

import ArxivClient.ArxivAPI.Article.Article;

import UI.MainWindow;
import UI.Stylesheet.StyleSheet;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import java.util.ArrayList;



public class SearchWindow  {

    private VBox vbox;
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
        searchButtonRow.getButton().setVisible(true);
        searchButtonRow.getButton().setOnAction(e -> searchArticles());



    }

    private void searchArticles() {

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
