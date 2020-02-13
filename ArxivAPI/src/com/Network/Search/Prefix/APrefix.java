package com.Network.Search.Prefix;

public abstract class APrefix {
    private String field;

    public APrefix(String field) {
        setField(field);
    }

    public void setField(String field) {
        field = field.trim();
        this.field = field.replaceAll(" {2,}", " ");
    }

    public String getBody() {
        if(field.isEmpty()) {
            return field;
        }

        String result = getPrefix() + ":";

        if(field.contains(" ")) {
            String newField = "";
            newField += "%22";
            newField += field.replace(" ", "+");
            newField += "%22";
            result+=newField;
        } else {
            result+=field;
        }

        return result;
    }

    public String toString() {
        return field;
    }

    public abstract String getPrefix();
}

