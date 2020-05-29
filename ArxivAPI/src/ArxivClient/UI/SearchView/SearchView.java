package ArxivClient.UI.SearchView;

import ArxivClient.ArxivAPI.Parameters.MaxResult;
import ArxivClient.ArxivAPI.Parameters.Start;
import ArxivClient.ArxivAPI.SearchRequest;
import ArxivClient.UI.LoadingPane;
import ArxivClient.UI.MainView.MainController;
import ArxivClient.UI.ResultView.ArticleResultModel;
import ArxivClient.UI.ResultView.ResultView;
import ArxivClient.UIBridge.SearchArticleService;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class SearchView extends BorderPane {

    VBox paneForRows;
    HBox paneForBottom;

    SearchRowHandler searchRowHandler;

    Button searchButton;
    Button addButton;

    ScrollPane contentPane;

    ResultView resultView;
    SearchArticleService searchArticleService;

    StartAtPane startAtPane;
    MaxValuePane maxValuePane;

    LoadingPane loadingPane;

    public SearchView() {
        paneForRows = new VBox();
        paneForBottom = new HBox();
        searchButton = new Button("Search");
        addButton = new Button("Add");
        searchRowHandler = new SearchRowHandler(paneForRows);
        resultView = new ResultView();
        searchArticleService = new SearchArticleService(resultView.getResultModels());
        startAtPane = new StartAtPane();
        maxValuePane = new MaxValuePane();
        loadingPane = new LoadingPane();

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
        paneForBottom.getChildren().add(startAtPane);
        paneForBottom.getChildren().add(searchButton);
        paneForBottom.getChildren().add(maxValuePane);

        //Венутсья к экрану поиска
        resultView.getReturnButton().setOnAction(e -> {
            showResultView(false);
        });

        searchArticleService.setOnRunning(e -> {
            Platform.runLater(()->{
                paneForBottom.setVisible(false);
                loadingPane.startLoading();
                setCenter(loadingPane);
            });
        });

        searchArticleService.setOnSucceeded(e -> {
            Platform.runLater(()->{
                loadingPane.stopLoading();
                showResultView(true);
            });
        });


        //Выполнить поиск
        searchButton.setOnAction(e -> {
            String query = searchRowHandler.getSearchRequest().getAbsoluteString();
            System.out.println(query);

            SearchRequest searchRequest = searchRowHandler.getSearchRequest();
            searchRequest.setMaxResult(new MaxResult(maxValuePane.getValue()));
            searchRequest.setStart(new Start(startAtPane.getValue()));

            searchArticleService.reset();
            searchArticleService.setSearchRequest(searchRequest);
            searchArticleService.start();

        });

        searchArticleService.setOnFailed(e -> {
            searchArticleService.getException().printStackTrace();
        });


        addButton.setOnAction(e -> {
            ObservableList<ArticleResultModel> listInResult = getListInResults();
            ObservableList<ArticleResultModel> listInDownloads = MainController.getDownloadView().getArticleResultModels();
            listInResult.forEach((article) -> {
                if(article.getCheckBox().isSelected()) {
                    if(listInDownloads.indexOf(article) == -1) {
                        ArticleResultModel articleToDownload = new ArticleResultModel(article);
                        MainController.getDownloadView().addArticle(articleToDownload);
                        article.getCheckBox().setVisible(false);
                    } else {
                        //TODO:: Fix this
                        article.getCheckBox().setVisible(false);
                    }
                }
            });

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
        if(flag) {
            setCenter(resultView);
            int searchIndex = paneForBottom.getChildren().indexOf(searchButton);
            paneForBottom.getChildren().set(searchIndex, addButton);
            startAtPane.setVisible(false);
            maxValuePane.setVisible(false);
        } else {
            setCenter(contentPane);
            int downloadIndex = paneForBottom.getChildren().indexOf(addButton);
            paneForBottom.getChildren().set(downloadIndex, searchButton);
            startAtPane.setVisible(true);
            maxValuePane.setVisible(true);
        }
        paneForBottom.setVisible(true);
    }

    public ObservableList<ArticleResultModel> getListInResults() {
        return resultView.getResultModels();
    }

}
