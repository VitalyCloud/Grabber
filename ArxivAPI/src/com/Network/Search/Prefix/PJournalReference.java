package com.Network.Search.Prefix;

public class PJournalReference extends APrefix {
    public PJournalReference(String field) {
        super(field);
    }

    @Override
    public String getPrefix() {
        return "jr";
    }
}
