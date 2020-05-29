package UI.SearchResultWindow;

import ArxivClient.ArxivAPI.Article.Article;
import UI.Stylesheet.StyleSheet;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;



public class SearchResultRow extends Pane {

    Article article;

    public SearchResultRow(Article article) {
        super();
        this.article = article;

        getStylesheets().add(StyleSheet.get());
        getStyleClass().add("search-result-row");

        //TODO: Move to stysheet
        setPrefSize(1076, 293);

        VBox vBox = new VBox();

        Label label = new Label(article.getTitle());
        vBox.getChildren().add(label);

        getChildren().add(vBox);
    }

    public SearchResultRow() {
        super();
        this.article = article;

        getStylesheets().add(StyleSheet.get());
        getStyleClass().add("search-result-row");

        //TODO: Move to stysheet
        setPrefSize(1076, 293);
    }

    public Article getArticle() {
        return article;
    }

}
