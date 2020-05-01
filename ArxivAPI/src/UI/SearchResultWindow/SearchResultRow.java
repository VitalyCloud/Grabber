package UI.SearchResultWindow;

import UI.Stylesheet.StyleSheet;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;



public class SearchResultRow extends Pane {

    public SearchResultRow() {
        super();
        getStylesheets().add(StyleSheet.get());
        getStyleClass().add("search-result-row");
        setPrefSize(1076, 293);

        VBox hBox = new VBox();

        Label first = new Label("qweqweqweqweqweqweqwe: ---------------------------------------\n" +
                "-----------------------------------------------------------------------------------\n" +
                "-----------------------------------------------------------------------------------\n" +
                "-----------------------------------------------------------------------------------\n");
        Label second = new Label("qweqweqweqweqweqweqwe");
        Label third = new Label("qweqweqweqweqweqweqwe");
        Label forth = new Label("qweqweqweqweqweqweqwe");

        hBox.getChildren().addAll(first, second, third, forth);

        getChildren().add(hBox);
    }

}
