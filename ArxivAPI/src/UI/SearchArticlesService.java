package UI;

import ArxivClient.ArxivAPI.Article.Article;
import ArxivClient.ArxivAPI.ArxivManager;
import ArxivClient.ArxivAPI.Search.SearchException;
import ArxivClient.ArxivAPI.Search.SearchRequest;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;


public class SearchArticlesService extends Service<ArrayList<Article>> {

    private SearchRequest searchRequest;
    private ArxivManager arxivManager = new ArxivManager();

    public SearchArticlesService() {

    }

    @Override
    protected Task<ArrayList<Article>> createTask() {
        Task<ArrayList<Article>> task = new Task<ArrayList<Article>>() {
            @Override
            protected ArrayList<Article> call() throws Exception {
                if(searchRequest==null) {
                    throw new SearchException();
                }

                CompletableFuture<ArrayList<Article>> cmpFuture = arxivManager.search(searchRequest);
                cmpFuture.exceptionally((error) ->{
                    this.setException(error);
                    return new ArrayList<>();
                });

                return arxivManager.search(searchRequest).get();
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
