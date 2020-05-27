package ArxivClient.UI.SearchView;

import ArxivClient.UI.ResultView.ResultView;
import ArxivClient.UIBridge.SearchArticleService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class SearchView extends BorderPane {

    VBox paneForRows;
    HBox paneForBottom;

    SearchRowHandler searchRowHandler;

    Button searchButton;
    Button downloadButton;

    ScrollPane contentPane;


    ResultView resultView;
    SearchArticleService searchArticleService;

    public SearchView() {
        paneForRows = new VBox();
        paneForBottom = new HBox();
        searchButton = new Button("Search");
        downloadButton = new Button("Download");
        searchRowHandler = new SearchRowHandler(paneForRows);
        resultView = new ResultView();
        searchArticleService = new SearchArticleService(resultView.getResultModels());

        contentPane = new ScrollPane();
        contentPane.setFitToWidth(true);
        contentPane.setFitToHeight(true);
        contentPane.setContent(paneForRows);

        setCenter(contentPane);
        setBottom(paneForBottom);

        configViewStyle();
        configLogic();
    }

    public void configLogic() {
        paneForBottom.getChildren().add(searchButton);

        //Венутсья к экрану поиска
        resultView.getReturnButton().setOnAction(e -> {
            showResultView(false);
        });


        //Выполнить поиск
        searchButton.setOnAction(e -> {
            String query = searchRowHandler.getSearchRequest().getAbsoluteString();
            System.out.println(query);

            searchArticleService.reset();
            searchArticleService.setSearchRequest(searchRowHandler.getSearchRequest());
            searchArticleService.start();

            showResultView(true);
        });

        searchArticleService.setOnFailed(e -> {
            searchArticleService.getException().printStackTrace();
        });
    }

    public void configViewStyle() {
        paneForBottom.setAlignment(Pos.CENTER);
        paneForBottom.setPadding(new Insets(10, 0, 10, 0));
        paneForBottom.setSpacing(10);

        paneForRows.setAlignment(Pos.TOP_CENTER);
        paneForRows.setSpacing(10);
        paneForRows.setPadding(new Insets(10, 10, 10, 10));
    }

    private void showResultView(boolean flag) {
        //TODO: после поиска и возвращения обратно, нижняя панель при большом количестве строк поиска уходит вниз
        if(flag) {
            setCenter(resultView);
            int searchIndex = paneForBottom.getChildren().indexOf(searchButton);
            paneForBottom.getChildren().set(searchIndex, downloadButton);
        } else {
            setCenter(paneForRows);
            int downloadIndex = paneForBottom.getChildren().indexOf(downloadButton);
            paneForBottom.getChildren().set(downloadIndex, searchButton);
        }
    }

}
