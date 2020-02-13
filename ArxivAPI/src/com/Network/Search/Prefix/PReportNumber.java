package com.Network.Search.Prefix;

public class PReportNumber extends APrefix {
    public PReportNumber(String field) {
        super(field);
    }

    @Override
    public String getPrefix() {
        return "rn";
    }
}
