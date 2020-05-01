package UI;

import UI.Control.MenuBar;
import UI.Control.StatusBar;
import UI.Search.SearchWindow;
import UI.SearchResultWindow.SearchResultWindow;
import javafx.scene.layout.BorderPane;

public class MainWindow extends BorderPane {

    private static MenuBar menuBar;
    private static StatusBar statusBar;
    private static SearchWindow searchWindow;
    private static SearchResultWindow searchResultWindow;


    public MainWindow() {
        super();

        menuBar = new MenuBar();
        statusBar = new StatusBar();
        searchWindow = new SearchWindow();
    }

    public void config() {
        setLeft(menuBar.getPane());
        setTop(statusBar.getPane());
//        setCenter(searchWindow.getPane());

        searchResultWindow = new SearchResultWindow();
        setCenter(searchResultWindow.getPane());

    }

    public static MenuBar getMenuBar() {
        return MainWindow.menuBar;
    }

    public static StatusBar getStatusBar() {
        return MainWindow.statusBar;
    }

    public static SearchWindow getSearchWindow() {
        return MainWindow.searchWindow;
    }

    public static SearchResultWindow getSearchResultWindow() {
        return MainWindow.searchResultWindow;
    }
}
