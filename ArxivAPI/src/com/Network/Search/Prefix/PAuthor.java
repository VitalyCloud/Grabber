package com.Network.Search.Prefix;

public class PAuthor extends APrefix {
    public PAuthor(String field) { super(field); }

    @Override
    public String getPrefix() {
        return "au";
    }
}
