package UI.SearchResultWindow;

import ArxivClient.ArxivAPI.Article.Article;
import UI.Stylesheet.StyleSheet;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class SearchResultWindow {

    VBox pane;
    SearchResultKeeper searchResultKeeper;
//    SearchCompletion searchCompletion;

    public SearchResultWindow() {
        pane = new VBox();
        searchResultKeeper = new SearchResultKeeper(pane);
        pane.getStylesheets().add(StyleSheet.get());
        pane.getStyleClass().add("search-result-window");

//        searchCompletion = new SearchCompletion() {
//            @Override
//            public void complete(ArrayList<Article> data, Throwable error) {
//                if(error==null) {
//                    if(data.isEmpty()) {
//                        //TODO: Handle empty completion
//                        System.out.println("Nothing searched");
//                    } else {
//                        System.out.println("Searched " + data.size() + " articles");
//                        searchResultKeeper.setArticles(data);
//                    }
//                } else {
//                    //TODO: Handle error
//                    error.printStackTrace();
//                }
//            }
//        };
    }

    private void config() {

    }

//    public SearchCompletion getSearchCompletion() {
//        return searchCompletion;
//    }

    public SearchResultKeeper getSearchResultKeeper() {
        return searchResultKeeper;
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
