package com.ArxivAPI.Search.Parameters.Field.Prefix;

public class Prefix {
    private String field;
    private String prefix;

    public Prefix(String prefix, String field) {
        this.prefix = prefix;
        setField(field);
    }

    public String getPrefix() { return prefix; }
    public String getField() { return field; }

    public void setField(String field) {
        field = field.trim();
        this.field = field.replaceAll(" {2,}", " ");
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
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

}

