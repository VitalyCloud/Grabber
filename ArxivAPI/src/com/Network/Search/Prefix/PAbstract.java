package com.Network.Search.Prefix;

public class PAbstract extends APrefix {
    public PAbstract(String field) { super(field); }

    @Override
    public String getPrefix() {
        return "abs";
    }
}