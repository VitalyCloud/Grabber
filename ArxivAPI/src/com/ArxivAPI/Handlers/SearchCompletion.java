package com.ArxivAPI.Handlers;

import com.ArxivAPI.Article.Article;
import com.Network.Iterfaces.Handlers.GETRequestCompletion;

import java.util.ArrayList;

public abstract class SearchCompletion
        implements GETRequestCompletion<ArrayList<Article>> {}
