package ArxivClient.ArxivAPI.Handlers;

import ArxivClient.ArxivAPI.Article.Article;
import ArxivClient.Network.Iterfaces.Handlers.GETRequestCompletion;

import java.util.ArrayList;

public abstract class SearchCompletion
        implements GETRequestCompletion<ArrayList<Article>> {}
