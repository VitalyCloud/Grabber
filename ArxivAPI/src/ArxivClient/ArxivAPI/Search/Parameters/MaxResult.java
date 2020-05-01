package com.ArxivAPI.Search.Parameters;

public class MaxResult implements AParameter {

    private final String parameterName = "max_results=";
    private int value;

    public MaxResult(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return parameterName;
    }

    @Override
    public String getBody() {
        return getName() + value;
    }
}
