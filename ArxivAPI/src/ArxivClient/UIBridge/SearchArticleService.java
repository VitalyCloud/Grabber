package ArxivClient.UIBridge;

import ArxivClient.ArxivAPI.Article.Article;
import ArxivClient.ArxivAPI.ArxivManager;
import ArxivClient.ArxivAPI.SearchRequest;
import ArxivClient.UI.ResultView.ArticleResultModel;
import ArxivClient.UI.ResultView.TableResultView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.util.List;

public class SearchArticleService extends Service<ObservableList<ArticleResultModel>> {

    ArxivManager arxivManager = new ArxivManager();
    SearchRequest searchRequest;
    ObservableList<ArticleResultModel> observableList;

    public SearchArticleService(ObservableList<ArticleResultModel> observableList) {
        this.observableList = observableList;
    }

    @Override
    protected Task<ObservableList<ArticleResultModel>> createTask() {
        return new Task<ObservableList<ArticleResultModel>>() {
            @Override
            protected ObservableList<ArticleResultModel> call() throws Exception {
                if(searchRequest==null) {
                    throw new Exception("Search Request is null");
                }

                List<Article> result = arxivManager.search(searchRequest).get();

                observableList.clear();
                result.forEach((article -> {
                    observableList.add(new ArticleResultModel(article));
                }));

                return observableList;
            }
        };
    }

    public SearchRequest getSearchRequest() {
        return searchRequest;
    }

    public void setSearchRequest(SearchRequest searchRequest) {
        this.searchRequest = searchRequest;
    }
}


