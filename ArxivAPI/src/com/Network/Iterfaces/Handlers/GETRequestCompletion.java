package com.Network.Iterfaces.Handlers;

import com.ArxivAPI.Article.Article;

public interface GETRequestCompletion<T> {
    public void completion(T data, Throwable error);
}
