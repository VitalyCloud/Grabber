package ArxivClient.UI.ResultView;

import ArxivClient.ArxivAPI.Article.Article;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressIndicator;



public class ArticleResultModel extends Article {
    ProgressIndicator progressIndicator;
    CheckBox checkBox;

    String authorsAsString, categoriesAsString, journalRefsAsString;


    public ArticleResultModel(Article article) {
        super(article);
        setAuthorsAsString(article.getAuthors().toString());
        setCategoriesAsString(article.getCategories().toString());
        setJournalRefsAsString(article.getCategories().toString());

        progressIndicator = new ProgressIndicator();
        progressIndicator.setProgress(0);
        checkBox = new CheckBox();
    }

    public ProgressIndicator getProgressIndicator() {
        return progressIndicator;
    }

    public void setProgressIndicator(ProgressIndicator progressIndicator) {
        this.progressIndicator = progressIndicator;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public String getAuthorsAsString() {
        return authorsAsString;
    }

    public void setAuthorsAsString(String authorsAsString) {
        this.authorsAsString = authorsAsString;
    }

    public String getCategoriesAsString() {
        return categoriesAsString;
    }

    public void setCategoriesAsString(String categoriesAsString) {
        this.categoriesAsString = categoriesAsString;
    }

    public String getJournalRefsAsString() {
        return journalRefsAsString;
    }

    public void setJournalRefsAsString(String journalRefsAsString) {
        this.journalRefsAsString = journalRefsAsString;
    }
}
