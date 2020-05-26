package ArxivClient.UI.SearchView;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SearchView extends BorderPane {

    VBox paneForRows;
    HBox paneForSearchButton;

    SearchRowHandler searchRowHandler;

    Button searchButton;

    public SearchView() {
        paneForRows = new VBox();
        paneForSearchButton = new HBox();
        searchButton = new Button("Search");
        searchRowHandler = new SearchRowHandler(paneForRows);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setContent(paneForRows);

        setCenter(scrollPane);
        setBottom(paneForSearchButton);

        config();
    }

    public void config() {
        paneForSearchButton.getChildren().add(searchButton);
        paneForSearchButton.setAlignment(Pos.CENTER);
        paneForSearchButton.setPadding(new Insets(10, 0, 10, 0));
        paneForSearchButton.setSpacing(10);

        paneForRows.setAlignment(Pos.TOP_CENTER);
        paneForRows.setSpacing(10);
        paneForRows.setPadding(new Insets(10, 10, 10, 10));

        searchButton.setOnAction(e -> {
            String query = searchRowHandler.getSearchQuery().getAbsoluteString();
            System.out.println(query);
        });

    }

}
