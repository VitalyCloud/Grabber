package com.Network.Search;

import com.Network.ArxivManager;
import com.Network.Search.Field.AField;

public class SearchRequest {

    private final String domen = "http://export.arxiv.org/api/query?search_query=";
    private AField field;

    public SearchRequest(){
        field = null;
    }
    public SearchRequest(AField field) {
        this.field = field;
    }

    public void setField(AField field) {
        this.field = field;
    }

    public AField getField() {
        return field;
    }

    public String getBody() {
        return domen + field.getBody();
    }

    public void perform() throws Exception {
        if(field == null)
            throw new Exception("Field is null");
        ArxivManager.makeRequest(domen + field.getBody());
    }
}
