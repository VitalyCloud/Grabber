package ArxivClient.UI.ResultView;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.w3c.dom.Node;

public class ResultView extends BorderPane {

    private VBox paneForRows;
    private HBox paneForSearchButton;
    private HBox paneForReturnButton;

    private TableResultView tableResultView;

    private Button downloadButton;
    private Button returnButton;

    public ResultView() {
        paneForRows = new VBox();
        paneForSearchButton = new HBox();
        paneForReturnButton = new HBox();
        downloadButton = new Button("Download");
        returnButton = new Button("<- Return");
        tableResultView = new TableResultView();

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setContent(new TableResultView());

        setCenter(scrollPane);
        setBottom(paneForSearchButton);
        setTop(paneForReturnButton);

        config();
    }

    public void config() {
        paneForSearchButton.getChildren().add(downloadButton);
        paneForSearchButton.setAlignment(Pos.CENTER);
        paneForSearchButton.setPadding(new Insets(10, 0, 10, 0));
        paneForSearchButton.setSpacing(10);

        paneForReturnButton.setAlignment(Pos.CENTER_LEFT);
        paneForReturnButton.setPadding(new Insets(5,5,5,10));
        paneForReturnButton.getChildren().add(returnButton);

        paneForRows.setAlignment(Pos.TOP_CENTER);
        paneForRows.setSpacing(10);
        paneForRows.setPadding(new Insets(10, 10, 10, 10));
    }

    public Button getReturnButton() {
        return returnButton;
    }
}