package com.Network.Search.Prefix;

public class PSubjectCategory extends APrefix {
    public PSubjectCategory(String field) {
        super(field);
    }

    @Override
    public String getPrefix() {
        return "cat";
    }
}