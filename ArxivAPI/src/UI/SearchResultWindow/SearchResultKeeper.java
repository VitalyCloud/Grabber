package UI.SearchResultWindow;

import ArxivClient.ArxivAPI.Article.Article;
import ArxivClient.ArxivAPI.Handlers.SearchCompletion;
import UI.Search.SearchRow;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class SearchResultKeeper {
    VBox rootPane;

    SearchResultKeeper(VBox pane) {
        this.rootPane = pane;
        rootPane.getChildren().add(new SearchResultRow());
    }

    public void setArticles(ArrayList<Article> articles) {
        rootPane.getChildren().clear();

        System.out.println("Articles size " + articles.size());

        articles.forEach((article -> {
            SearchResultRow newRow = new SearchResultRow(article);
            rootPane.getChildren().add(newRow);
        }));
    }
}
