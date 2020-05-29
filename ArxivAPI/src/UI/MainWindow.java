package UI;


import ArxivClient.ArxivAPI.Article.Article;
import UI.Control.MenuBar;
import UI.Control.StatusBar;
import UI.Search.SearchWindow;
import UI.SearchResultWindow.SearchResultWindow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class MainWindow extends BorderPane {

    public static final MainWindow INSTANCE = new MainWindow();

    private MenuBar menuBar;
    private StatusBar statusBar;
    private SearchWindow searchWindow;
    private SearchResultWindow searchResultWindow;


    private MainWindow() {
        super();

        menuBar = new MenuBar();
        statusBar = new StatusBar();
        searchWindow = new SearchWindow();
        searchResultWindow = new SearchResultWindow();
    }

    public void config() {
        setLeft(menuBar.getPane());
        setTop(statusBar.getPane());
        setCenter(searchWindow.getPane());

        menuBar.getSearchButton().setOnAction(e -> {
            setCenter(searchWindow.getPane());
        });
        menuBar.getDownloadButton().setOnAction(e -> {
            setCenter(new HBox());
        });
        menuBar.getSettingsButton().setOnAction(e -> {
            setCenter(new HBox());
        });

    }



    public void showSearchResultWindow() {
        setCenter(searchResultWindow.getPane());
        statusBar.showReturnButton();
    }

    public void showSearchWindow() {
        setCenter(searchWindow.getPane());
        statusBar.showReturnButton();
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public StatusBar getStatusBar() {
        return statusBar;
    }

    public SearchWindow getSearchWindow() {
        return searchWindow;
    }

    public SearchResultWindow getSearchResultWindow() {
        return searchResultWindow;
    }
}
