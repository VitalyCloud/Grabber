package ArxivClient.UI.ResultView;


import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ResultView extends BorderPane {

    private HBox paneForReturnButton;
    private ScrollPane contentPane;

    private TableResultView tableResultView;

    private Button returnButton;

    private ObservableList<ArticleResultModel> resultModels;

    public ResultView() {
        paneForReturnButton = new HBox();
        returnButton = new Button("<- Return");
        tableResultView = new TableResultView();
        resultModels = FXCollections.observableArrayList();
        tableResultView.setItems(resultModels);

        contentPane = new ScrollPane();
        contentPane.setContent(tableResultView);

        setCenter(contentPane);
        setTop(paneForReturnButton);

        configViewStyle();
    }


    public void configViewStyle() {
        paneForReturnButton.setAlignment(Pos.CENTER_LEFT);
        paneForReturnButton.setPadding(new Insets(5,5,5,10));
        paneForReturnButton.getChildren().add(returnButton);

        contentPane.setFitToWidth(true);
        contentPane.setFitToHeight(true);
    }

    public Button getReturnButton() {
        return returnButton;
    }

    public ObservableList<ArticleResultModel> getResultModels() {
        return resultModels;
    }
}