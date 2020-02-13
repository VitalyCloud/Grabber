package com.Network.Search.Prefix;

public class PComment extends APrefix {
    public PComment(String field) {
        super(field);
    }

    @Override
    public String getPrefix() {
        return "co";
    }
}
