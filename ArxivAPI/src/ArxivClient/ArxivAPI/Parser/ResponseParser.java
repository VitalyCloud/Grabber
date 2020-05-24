package ArxivClient.ArxivAPI.Parser;

import ArxivClient.ArxivAPI.Article.Article;
import ArxivClient.ArxivAPI.Article.Author;
import ArxivClient.ArxivAPI.Parser.Exceptions.RequestError;
import ArxivClient.ArxivAPI.Parser.Exceptions.JDKParserException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class ResponseParser {

    private ArrayList<Article> articles;

    public ResponseParser() {
        articles = new ArrayList<>();
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void parseSearchRequest(String xmlResponse) throws JDKParserException, RequestError {

        System.out.println("Parsing xml response... ");

        //Array of articles
        articles.clear();

        Document document;
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            InputStream responseStream = new ByteArrayInputStream(xmlResponse.getBytes());
            document = builder.parse(responseStream);
        }
        catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
            throw new JDKParserException(e);
        }

        //Parsing
        XMLObject rootXml = new XMLObject(document.getDocumentElement());
        ArrayList<XMLObject> entries = rootXml.getElements("entry");
        for (XMLObject entrieXml : entries) {
            Article article = parseEntry(entrieXml);
            articles.add(article);
        }

        System.out.println("Parsing has been completed");

    }

    //Parse one entry
    private Article parseEntry(XMLObject xmlEntry) throws RequestError {

        Article article = new Article();

        String id = xmlEntry.getElement("id").getText();
        String published = xmlEntry.getElement("published").getText();
        String title = xmlEntry.getElement("title").getText();
        String summary = xmlEntry.getElement("summary").getText();
        String updated = xmlEntry.getElement("updated").getText();
        String primaryCategory = xmlEntry.getElement("arxiv:primary_category").getAttributeValue("term");
        String comment = xmlEntry.getElement("arxiv:comment").getText();
        String doi = xmlEntry.getElement("arxiv:doi").getText();

        //TODO: Make a tests
        if(title.equals("Error")) {
            throw new RequestError(summary);
        }

        article.setId(id);
        article.setPublished(published);
        article.setTitle(title);
        article.setSummary(summary);
        article.setLastUpdated(updated);
        article.setPrimaryCategory(primaryCategory);
        article.setComment(comment);
        article.setDoi(doi);

        //Authors parsing
        xmlEntry.getElements("author").forEach((author) -> {
            String name = author.getElement("name").getText();
            XMLObject affilation = author.getElement("arxiv:affiliation");
            if (!name.isEmpty()) {
                Author newAuthor = new Author();
                newAuthor.setName(name);
                if (!affilation.isEmpty())
                    newAuthor.setAffiliation(affilation.getText());
                article.getAuthors().add(newAuthor);
            }
        });

        //Links parsing
        xmlEntry.getElements("link").forEach((link) -> {
            if (link.getAttributeValue("rel").equals("alternate")) {
                String linkToWebSite = link.getAttributeValue("href");
                article.setLinkToWebSite(linkToWebSite);
            }

            if (link.getAttributeValue("title").equals("pdf")) {
                String linkToPDF = link.getAttributeValue("href");
                article.setLinkToPDF(linkToPDF);
            }
            if (link.getAttributeValue("title").equals("doi")) {
                String linkToDOI = link.getAttributeValue("href");
                article.setLinkToDOI(linkToDOI);
            }
        });

        //Refs parsing
        xmlEntry.getElements("arxiv:journal_ref").forEach((ref) -> {
            String refString = ref.getText();
            if (!refString.isEmpty()) {
                article.getJournalRefs().add(refString);
            }
        });

        //Categories parsing
        xmlEntry.getElements("category").forEach((cat) -> {
            String category = cat.getAttributeValue("term");
            article.getCategories().add(category);
        });

        return article;
    }

}
