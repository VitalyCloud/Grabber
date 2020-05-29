package ArxivClient.ArxivAPI.Article;

import java.util.ArrayList;
import java.util.Objects;

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
        authors = new ArrayList<>() {
            @Override
            public String toString() {
                String result = "";
                for(int i=0; i<authors.size(); i++) {
                    Author author = authors.get(i);
                    result+=author.toString() + "\n";
                }
                return result;
            }
        };
        categories = new ArrayList<>() {
            @Override
            public String toString() {
                String result = "";
                for(int i=0; i<categories.size(); i++)
                    result += categories.get(i) + "\n";
                return result;
            }
        };
        journalRefs = new ArrayList<>() {
            @Override
            public String toString() {
                String result = "";
                for(int i=0; i<journalRefs.size(); i++)
                    result += journalRefs.get(i) + "\n";
                return result;
            }
        };
    }

    //Copy Constructor
    public Article(Article article) {
        this();
        setId(article.getId());
        setLastUpdated(article.getLastUpdated());
        setTitle(article.getTitle());
        setPublished(article.getPublished());
        setSummary(article.getSummary());
        setAuthors(article.getAuthors());
        setCategories(article.getCategories());
        setLinkToWebSite(article.getLinkToWebSite());
        setLinkToPDF(article.getLinkToPDF());
        setLinkToDOI(article.getLinkToDOI());
        setPrimaryCategory(article.getPrimaryCategory());
        setJournalRefs(article.getJournalRefs());
        setComment(article.getComment());
        setDoi(article.getDoi());
    }

    public Article copy() {
        return new Article(this);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id!=null & !id.isEmpty())
            this.id = id;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        if(lastUpdated!=null & !lastUpdated.isEmpty())
            this.lastUpdated = lastUpdated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title!=null & !title.isEmpty())
            this.title = title;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        if(published!=null & !published.isEmpty())
            this.published = published;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        if(summary!=null & !summary.isEmpty())
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
        if(linkToWebSite!=null & !linkToWebSite.isEmpty())
            this.linkToWebSite = linkToWebSite;
    }

    public String getLinkToPDF() {
        return linkToPDF;
    }

    public void setLinkToPDF(String linkToPDF) {
        if(linkToPDF!=null & !linkToPDF.isEmpty())
            this.linkToPDF = linkToPDF;
    }

    public String getLinkToDOI() {
        return linkToDOI;
    }

    public void setLinkToDOI(String linkToDOI) {
        if(linkToDOI!=null && !linkToDOI.isEmpty())
            this.linkToDOI = linkToDOI;
    }

    public String getPrimaryCategory() {
        return primaryCategory;
    }

    public void setPrimaryCategory(String primaryCategory) {
        if(primaryCategory!=null & !primaryCategory.isEmpty())
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
        if(comment!=null && !comment.isEmpty())
            this.comment = comment;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        if(doi!=null && !doi.isEmpty())
            this.doi = doi;
    }

}
