package UI.SearchResultWindow;

import javafx.scene.layout.Pane;
import java.util.ArrayList;

public class SearchResultKeeper {
    Pane rootPane;
    ArrayList<SearchResultRow> searchRows;

    SearchResultKeeper(Pane pane) {
        this.rootPane = pane;
        searchRows = new ArrayList<>();

        SearchResultRow first = new SearchResultRow();
        rootPane.getChildren().add(first);

        SearchResultRow second = new SearchResultRow();
        rootPane.getChildren().add(second);
    }
}
