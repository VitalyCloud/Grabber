package ArxivClient.UI.ResultView;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ResultView extends BorderPane {

    private VBox paneForRows;
    private HBox paneForDownloadButton;
    private HBox paneForReturnButton;

    private TableResultView tableResultView;

    private Button downloadButton;
    private Button returnButton;

    private ObservableList<ArticleResultModel> resultModels;


    public ResultView() {
        paneForRows = new VBox();
        paneForDownloadButton = new HBox();
        paneForReturnButton = new HBox();
        downloadButton = new Button("Download");
        returnButton = new Button("<- Return");
        tableResultView = new TableResultView();
        resultModels = FXCollections.observableArrayList();
        tableResultView.setItems(resultModels);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setContent(tableResultView);

        setCenter(scrollPane);
//        setBottom(paneForDownloadButton);
        setTop(paneForReturnButton);

        config();
    }


    public void config() {
        paneForDownloadButton.getChildren().add(downloadButton);
        paneForDownloadButton.setAlignment(Pos.CENTER);
        paneForDownloadButton.setPadding(new Insets(10, 0, 10, 0));
        paneForDownloadButton.setSpacing(10);

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

    public ObservableList<ArticleResultModel> getResultModels() {
        return resultModels;
    }
}