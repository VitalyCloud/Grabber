package ArxivClient.UI.ResultView;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class ResultView extends BorderPane {

    private HBox paneForReturnButton;
    private ScrollPane contentPane;

    private TableResultView tableResultView;

    private Button returnButton;
    private Button setAllButton;
    private Button unsetAllButton;

    private ObservableList<ArticleResultModel> resultModels;

    public ResultView() {
        paneForReturnButton = new HBox();
        returnButton = new Button("<- Return");
        tableResultView = new TableResultView();
        setAllButton = new Button("Set All");
        unsetAllButton = new Button("Unset All");
        resultModels = FXCollections.observableArrayList();
        tableResultView.setItems(resultModels);

        contentPane = new ScrollPane();
        contentPane.setContent(tableResultView);

        setCenter(contentPane);
        setTop(paneForReturnButton);

        configViewStyle();
        configLogic();
    }


    private void configViewStyle() {
        paneForReturnButton.setAlignment(Pos.CENTER_LEFT);
        paneForReturnButton.setPadding(new Insets(5,5,5,10));
        paneForReturnButton.setSpacing(5);
        paneForReturnButton.getChildren().addAll(returnButton, setAllButton, unsetAllButton);

        contentPane.setFitToWidth(true);
        contentPane.setFitToHeight(true);
    }

    private void configLogic() {
        setAllButton.setOnAction(e -> {
            getResultModels().forEach((model) -> {
                model.getCheckBox().setSelected(true);
            });
        });
        unsetAllButton.setOnAction(e -> {
            getResultModels().forEach((model) ->{
                model.getCheckBox().setSelected(false);
            });
        });
    }

    public Button getReturnButton() {
        return returnButton;
    }

    public ObservableList<ArticleResultModel> getResultModels() {
        return resultModels;
    }
}