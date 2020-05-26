package ArxivClient.UI.ResultView;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressIndicator;

import javax.swing.table.TableColumn;

public class ArticleResultModel {
    ProgressIndicator progressIndicator;
    CheckBox checkBox;
    String author, title;

    ArticleResultModel(String author, String title) {
        progressIndicator = new ProgressIndicator();
        progressIndicator.setProgress(0);
        checkBox = new CheckBox();
        this.author = author;
        this.title = title;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
