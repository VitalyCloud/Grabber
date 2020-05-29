package ArxivClient.UI.DownloadView;

import ArxivClient.Application;
import ArxivClient.Network.DownloadManager;
import ArxivClient.UI.MainView.MainController;
import ArxivClient.UI.ResultView.ArticleResultModel;
import ArxivClient.UI.ResultView.TableResultView;
import ArxivClient.UIBridge.DownloadFXTask;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


public class DownloadView extends BorderPane {

    private static int downloadDelay;

    private TableResultView tableResultView;
    private ScrollPane contentPane;
    private HBox paneForDownloadButton;
    private Button downloadButton;
    private Button cancelButton;
    private Button cancelAllButton;

    private ObservableList<ArticleResultModel> articleResultModels;

    public DownloadView() {
        tableResultView = new TableResultView();
        contentPane = new ScrollPane();
        paneForDownloadButton = new HBox();
        downloadButton = new Button("Dwonload");
        cancelButton = new Button("Cancel");
        cancelAllButton = new Button("Cancel all");
        articleResultModels = FXCollections.observableArrayList();
        tableResultView.setItems(articleResultModels);

        paneForDownloadButton.getChildren().add(downloadButton);
        paneForDownloadButton.getChildren().add(cancelButton);
        paneForDownloadButton.getChildren().add(cancelAllButton);

        contentPane.setContent(tableResultView);

        setCenter(contentPane);
        setBottom(paneForDownloadButton);
        configViewStyle();
        configLogic();

        String downloadDelay = Application.getPreferences().get("downloadDelay","0");
        setDownloadDelay(downloadDelay);
    }

    private void configLogic() {
        downloadButton.setOnAction(e -> {
            System.out.println("Download button pressed");
            downloadButtonPressed();
        });

        cancelButton.setOnAction(e -> {
            System.out.println("Cancel button pressed");
            cancelButtonPressed(false);
        });

        //TODO::Test this. Not well work
        cancelAllButton.setOnAction(e -> {
            cancelButtonPressed(true);
        });
    }

    private void configViewStyle() {
        paneForDownloadButton.setAlignment(Pos.CENTER);
        paneForDownloadButton.setPadding(new Insets(10, 0, 10, 0));
        paneForDownloadButton.setSpacing(10);

        contentPane.setFitToWidth(true);
        contentPane.setFitToHeight(true);

        tableResultView.getProgressColumn().setVisible(true);
    }

    public void addArticle(ArticleResultModel article) {
        article.getCheckBox().setSelected(true);
        article.getProgressIndicator().setVisible(false);
        articleResultModels.add(article);
    }

    public ObservableList<ArticleResultModel> getArticleResultModels() {
        return articleResultModels;
    }


    static boolean alertIsShowing = false;

    private void downloadButtonPressed() {
        articleResultModels.forEach((model) -> {
            if(model.getCheckBox().isSelected() && !model.downloadIsRunning()) {

                DownloadFXTask downloadFXTask = model.createDownloadTask();


                int randomNum = ThreadLocalRandom.current().nextInt(0, downloadDelay==0 ? 1: downloadDelay);
                System.out.println("Random number: " + randomNum);
                DownloadManager.downloadWithDelay(downloadFXTask, randomNum, TimeUnit.SECONDS);

                downloadFXTask.setOnRunning(e -> {
                    Platform.runLater(() -> {
                        model.getProgressIndicator().setVisible(true);
                        model.getCheckBox().setSelected(false);
                        model.getCheckBox().setVisible(true);
                    });
                });

                downloadFXTask.setOnFailed(e -> {
                    Platform.runLater(() -> {
                        model.getCheckBox().setVisible(true);
                        model.getCheckBox().setSelected(false);
                        model.getProgressIndicator().setVisible(false);
                    });
                    System.out.println("Failed \n" + model.getTitle());
                    downloadFXTask.getException().printStackTrace();


                    if(alertIsShowing==false) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error while downloading");
                        alert.setContentText(downloadFXTask.getException().getMessage());
                        alertIsShowing = true;
                        alert.showAndWait();
                        alertIsShowing = false;
                    }
                });

                downloadFXTask.setOnSucceeded(e -> {
                    System.out.println("Success " + model.getTitle());
                    Platform.runLater(() -> {
                        model.getCheckBox().setVisible(false);
                        model.getCheckBox().setSelected(false);
                    });
                });

                downloadFXTask.setOnCancelled(e -> {
                    model.cancelDownloadTask();
                    Platform.runLater(() -> {
                        articleResultModels.remove(model);
                    });
                });

                model.getCheckBox().setVisible(false);
                model.getCheckBox().setSelected(false);
            }
        });
    }

    private void cancelButtonPressed(boolean cancelAllFlag) {
        ObservableList<ArticleResultModel> listInResults = MainController.getSearchView().getListInResults();
        for (int i=0; i<articleResultModels.size(); i++) {
            ArticleResultModel model = articleResultModels.get(i);
            if(model.getCheckBox().isSelected() || cancelAllFlag) {
                articleResultModels.remove(model);
                model.cancelDownloadTask();

                int index = listInResults.indexOf(model);
                if(index!=-1) {
                    listInResults.get(index).getCheckBox().setVisible(true);
                    listInResults.get(index).getCheckBox().setSelected(false);
                }
            }
        }
    }


    public static void setDownloadDelay(String value) {
        value.replaceFirst(";", "");
        downloadDelay = Integer.valueOf(value).intValue();
    }
}
