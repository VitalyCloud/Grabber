package com.Network.Search.Prefix;

public class PAll extends APrefix {
    public PAll(String field) {
        super(field);
    }

    @Override
    public String getPrefix() {
        return "all";
    }
}
