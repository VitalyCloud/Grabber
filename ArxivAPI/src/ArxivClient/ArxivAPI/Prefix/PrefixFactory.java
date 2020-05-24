package ArxivClient.ArxivAPI.Search.Field.Prefix;

public class PrefixFactory {

    public Prefix all(String field) {
        return new Prefix("all", field);
    }

    public Prefix author(String field) {
        return new Prefix("au", field);
    }

    public Prefix _abstract(String field) {
        return new Prefix("abs", field);
    }

    public Prefix comment(String field) {
        return new Prefix("co", field);
    }

    public Prefix id(String field) {
        return new Prefix("id", field);
    }

    public Prefix journalReference(String field) {
        return new Prefix("jr", field);
    }

    public Prefix reportNumber(String field) {
        return new Prefix("rn", field);
    }

    public Prefix subjectCategory(String field) {
        return new Prefix("cat", field);
    }

    public Prefix title(String field) {
        return new Prefix("ti", field);
    }


}
