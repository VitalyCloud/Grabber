package ArxivClient.ArxivAPI.Prefix;

public class Prefix {
    private String value;
    private String prefix;

    public Prefix(String prefix, String value) {
        this.prefix = prefix;
        setValue(value);
    }

    public Prefix(PrefixID id, String field) {
        this.prefix = id.name();
        setValue(field);
    }

    public String getPrefix() { return prefix; }
    public String getValue() { return value; }

    public void setValue(String value) {
        value = value.trim();
        this.value = value.replaceAll(" {2,}", " ");
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getBody() {
        if(value.isEmpty()) {
            return value;
        }

        String result = getPrefix() + ":";

        if(value.contains(" ")) {
            String newField = "";
            newField += "%22";
            newField += value.replace(" ", "+");
            newField += "%22";
            result+=newField;
        } else {
            result+= value;
        }

        return result;
    }

    public String toString() {
        return value;
    }

}

