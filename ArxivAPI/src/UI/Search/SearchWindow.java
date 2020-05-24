package UI.Search;

import ArxivClient.ArxivAPI.Article.Article;
import ArxivClient.ArxivAPI.Search.Parameters.MaxResult;
import ArxivClient.ArxivAPI.Search.Parameters.SearchQuery;
import ArxivClient.ArxivAPI.Search.SearchRequest;
import UI.MainWindow;
import UI.SearchArticlesService;
import UI.Stylesheet.StyleSheet;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class SearchWindow  {

    private VBox vbox;
    private SearchRowKeeper rowKeeper;
    private SearchButtonRow searchButtonRow;
    private SearchArticlesService searchArticlesService;

    BorderPane pane;

    public SearchWindow() {

        pane = new BorderPane();
        vbox = new VBox();
        rowKeeper = new SearchRowKeeper(vbox);
        searchButtonRow = new SearchButtonRow();
        searchArticlesService = new SearchArticlesService();


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

        //Показать экран результата при удачном поиске
        searchArticlesService.setOnSucceeded(e -> {
            ArrayList<Article> result = searchArticlesService.getValue();
            MainWindow.INSTANCE.getSearchResultWindow().getSearchResultKeeper().setArticles(result);
            MainWindow.INSTANCE.showSearchResultWindow();
        });



        searchArticlesService.setOnFailed(e-> {

        });
    }

    private void searchArticles() {
        SearchQuery query = rowKeeper.getSearchQuery();
        SearchRequest searchRequest = new SearchRequest(query);
        searchRequest.setMaxResult(new MaxResult(20));

        searchArticlesService.setSearchRequest(searchRequest);
        if(!searchArticlesService.isRunning()) {
            searchArticlesService.reset();
            searchArticlesService.start();
        } else {
            System.out.println("Service is running");
        }

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
