package ArxivClient.UI.ResultView;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableResultView extends TableView<ArticleResultModel> {


    private TableColumn<ArticleResultModel, ProgressIndicator> progressColumn;
    private TableColumn<ArticleResultModel, CheckBox> checkBoxColumn;

    private TableResultColumn idColumn;
    private TableResultColumn lastUpdatedColumn;
    private TableResultColumn titleColumn;
    private TableResultColumn publishedColumn;
    private TableResultColumn summaryColumn;
    private TableResultColumn authorsColumn;
    private TableResultColumn categoriesColumn;
    private TableResultColumn linkToWebSiteColumn;
    private TableResultColumn linkToPDFColumn;
    private TableResultColumn linkToDOIColumn;
    private TableResultColumn primaryCategoryColumn;
    private TableResultColumn journalRefsColumn;
    private TableResultColumn commentColumn;
    private TableResultColumn doiColumn;

    public TableResultView() {
        progressColumn = new TableColumn<>();
        checkBoxColumn = new TableColumn<>();
        checkBoxColumn.setCellValueFactory(new PropertyValueFactory<>("checkBox"));
        progressColumn.setCellValueFactory(new PropertyValueFactory<>("progressIndicator"));

        idColumn = new TableResultColumn("id", "id");
        lastUpdatedColumn = new TableResultColumn("lastUpdated", "lastUpdated");
        titleColumn = new TableResultColumn("title", "title");
        publishedColumn = new TableResultColumn("published", "published");
        summaryColumn = new TableResultColumn("summary", "summary");
        authorsColumn = new TableResultColumn("authors", "authorsAsString");
        categoriesColumn = new TableResultColumn("categories", "categoriesAsString");
        linkToWebSiteColumn = new TableResultColumn("linkToWebSite", "linkToWebSite");
        linkToPDFColumn = new TableResultColumn("linkToPDF", "linkToPDF");
        linkToDOIColumn = new TableResultColumn("linkToDOI", "linkToDOI");
        primaryCategoryColumn = new TableResultColumn("primaryCategory", "primaryCategory");
        journalRefsColumn = new TableResultColumn("journalRefs", "journalRefs");
        commentColumn = new TableResultColumn("comment", "comment");
        doiColumn = new TableResultColumn("doi", "doi");

        getColumns().addAll(checkBoxColumn, progressColumn, idColumn, lastUpdatedColumn, titleColumn,
                publishedColumn, summaryColumn, authorsColumn, categoriesColumn, linkToDOIColumn,
                linkToPDFColumn, linkToWebSiteColumn, primaryCategoryColumn, journalRefsColumn, commentColumn,
                doiColumn);

        idColumn.setVisible(false);
        lastUpdatedColumn.setVisible(false);
        summaryColumn.setVisible(false);
        linkToDOIColumn.setVisible(false);
        journalRefsColumn.setVisible(false);
        commentColumn.setVisible(false);
        doiColumn.setVisible(false);
        progressColumn.setVisible(false);
    }

    static class TableResultColumn extends TableColumn<ArticleResultModel, String> {
        public TableResultColumn(String title, String binding) {
            super(title);
            setCellValueFactory(new PropertyValueFactory<>(binding));
        }
    }

    public TableColumn<ArticleResultModel, ProgressIndicator> getProgressColumn() {
        return progressColumn;
    }

    public TableColumn<ArticleResultModel, CheckBox> getCheckBoxColumn() {
        return checkBoxColumn;
    }

    public TableColumn<ArticleResultModel, String> getIdColumn() {
        return idColumn;
    }

    public TableColumn<ArticleResultModel, String> getLastUpdatedColumn() {
        return lastUpdatedColumn;
    }

    public TableColumn<ArticleResultModel, String> getTitleColumn() {
        return titleColumn;
    }

    public TableColumn<ArticleResultModel, String> getPublishedColumn() {
        return publishedColumn;
    }

    public TableColumn<ArticleResultModel, String> getSummaryColumn() {
        return summaryColumn;
    }

    public TableColumn<ArticleResultModel, String> getAuthorsColumn() {
        return authorsColumn;
    }

    public TableColumn<ArticleResultModel, String> getCategoriesColumn() {
        return categoriesColumn;
    }

    public TableColumn<ArticleResultModel, String> getLinkToWebSiteColumn() {
        return linkToWebSiteColumn;
    }

    public TableColumn<ArticleResultModel, String> getLinkToPDFColumn() {
        return linkToPDFColumn;
    }

    public TableColumn<ArticleResultModel, String> getLinkToDOIColumn() {
        return linkToDOIColumn;
    }

    public TableColumn<ArticleResultModel, String> getPrimaryCategoryColumn() {
        return primaryCategoryColumn;
    }

    public TableColumn<ArticleResultModel, String> getJournalRefsColumn() {
        return journalRefsColumn;
    }

    public TableColumn<ArticleResultModel, String> getCommentColumn() {
        return commentColumn;
    }

    public TableColumn<ArticleResultModel, String> getDoiColumn() {
        return doiColumn;
    }
}
