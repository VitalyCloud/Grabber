package ArxivClient.ArxivAPI.Article;

public class Author {
    private String name = "";
    private String affiliation = "";
    public Author() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public void print(){
        System.out.println("Author:");
        System.out.println("\tname: " + name);
        System.out.println("\taffiliation: " + affiliation);
    }

    @Override
    public String toString() {
        String result = name;
        if(hasAffiliation())
            result+= " (" + getAffiliation() + ")";;
        return result;
    }

    public String getName() {
        return name;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public boolean hasAffiliation() {
        return affiliation!="" ? true : false;
    }
}