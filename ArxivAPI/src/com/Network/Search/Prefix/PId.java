package com.Network.Search.Prefix;

public class PId extends APrefix {
    public PId(String field) {
        super(field);
    }

    @Override
    public String getPrefix() {
        return "id";
    }
}