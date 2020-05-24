package ArxivClient;

import ArxivClient.ArxivAPI.Article.Article;
import ArxivClient.ArxivAPI.ArxivManager;
import ArxivClient.ArxivAPI.SearchRequest;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.util.List;

public class SearchArticleService extends Service<List<Article>> {

    ArxivManager arxivManager = new ArxivManager();
    SearchRequest searchRequest;

    @Override
    protected Task<List<Article>> createTask() {
        return new Task<List<Article>>() {
            @Override
            protected List<Article> call() throws Exception {
                if(searchRequest==null) {
                    throw new Exception("Search Request is null");
                }
                List<Article> result = arxivManager.search(searchRequest).get();
                return result;
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


