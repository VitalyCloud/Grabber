package ArxivClient.ArxivAPI.Article;

import java.util.ArrayList;

public class Article {

    //Article info
    private String id;
    private String lastUpdated;
    private String title;
    private String published;
    private String summary;

    private ArrayList<Author> authors;
    private ArrayList<String> categories;

    //Links
    private String linkToWebSite;
    private String linkToPDF;
    private String linkToDOI;

    //Extension elements
    private String primaryCategory;
    private ArrayList<String> journalRefs;
    private String comment;
    private String doi;

    public Article() {
        authors = new ArrayList<>();
        categories = new ArrayList<>();
        journalRefs = new ArrayList<>();
    }

    public void print() {
        System.out.println("id: " + id);
        System.out.println("lastUpdated: " + lastUpdated);
        System.out.println("title: " + title);
        System.out.println("published: " + published);
        System.out.println("summary: " + summary);

        authors.forEach((element) -> element.print());

        System.out.print("Categories: ");
        categories.forEach((element) -> System.out.print(element + "; "));
        System.out.println();

        System.out.println("linkToWebSite: " + linkToWebSite);
        System.out.println("linkToPDF: " + linkToPDF);
        System.out.println("linkToDOI: " + linkToDOI);
        System.out.println("primary category: " + primaryCategory);

        System.out.println("comment: " + comment);
        System.out.println("doi: " + doi);

        System.out.println("journalRefs: ");
        journalRefs.forEach((element) -> System.out.println("\t" + element));

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(!id.isEmpty())
            this.id = id;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        if(!lastUpdated.isEmpty())
            this.lastUpdated = lastUpdated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(!title.isEmpty())
            this.title = title;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        if(!published.isEmpty())
            this.published = published;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        if(!summary.isEmpty())
            this.summary = summary;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public String getLinkToWebSite() {
        return linkToWebSite;
    }

    public void setLinkToWebSite(String linkToWebSite) {
        if(!linkToWebSite.isEmpty())
            this.linkToWebSite = linkToWebSite;
    }

    public String getLinkToPDF() {
        return linkToPDF;
    }

    public void setLinkToPDF(String linkToPDF) {
        if(!linkToPDF.isEmpty())
            this.linkToPDF = linkToPDF;
    }

    public String getLinkToDOI() {
        return linkToDOI;
    }

    public void setLinkToDOI(String linkToDOI) {
        if(!linkToDOI.isEmpty())
            this.linkToDOI = linkToDOI;
    }

    public String getPrimaryCategory() {
        return primaryCategory;
    }

    public void setPrimaryCategory(String primaryCategory) {
        if(!primaryCategory.isEmpty())
            this.primaryCategory = primaryCategory;
    }

    public ArrayList<String> getJournalRefs() {
        return journalRefs;
    }

    public void setJournalRefs(ArrayList<String> journalRefs) {
        this.journalRefs = journalRefs;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        if(!comment.isEmpty())
            this.comment = comment;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        if(!doi.isEmpty())
            this.doi = doi;
    }

}
