package com.ArxivAPI.Search.Parameters;

import com.ArxivAPI.Search.Field.Field;

public class SearchQuery implements AParameter {

    private final String paramenterName = "search_query=";
    private Field field;

    public SearchQuery(Field field) {
        this.field = field;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    @Override
    public String getName() {
        return paramenterName;
    }

    @Override
    public String getBody() {
        return getName() + field.getBody();
    }
}
