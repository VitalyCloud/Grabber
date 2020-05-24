package ArxivClient.ArxivAPI.Prefix;

public class PrefixFactory {

    public static Prefix all(String field) {
        return new Prefix("all", field);
    }

    public static Prefix author(String field) {
        return new Prefix("au", field);
    }

    public static Prefix _abstract(String field) {
        return new Prefix("abs", field);
    }

    public static Prefix comment(String field) {
        return new Prefix("co", field);
    }

    public static Prefix id(String field) {
        return new Prefix("id", field);
    }

    public static Prefix journalReference(String field) {
        return new Prefix("jr", field);
    }

    public static Prefix reportNumber(String field) {
        return new Prefix("rn", field);
    }

    public static Prefix subjectCategory(String field) {
        return new Prefix("cat", field);
    }

    public static Prefix title(String field) {
        return new Prefix("ti", field);
    }


}
