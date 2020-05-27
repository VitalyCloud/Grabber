package ArxivClient.UI.ResultView;


import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableResultView extends TableView<ArticleResultModel> {


    private TableColumn<ArticleResultModel, ProgressIndicator> progressColumn;
    private TableColumn<ArticleResultModel, String> authorColumn;
    private TableColumn<ArticleResultModel, String> titleColumn;
    private TableColumn<ArticleResultModel, CheckBox> checkBoxColumn;

    public TableResultView() {

        progressColumn = new TableColumn<>();
        authorColumn = new TableColumn<>("Author");
        titleColumn = new TableColumn<>("Title");
        checkBoxColumn = new TableColumn<>();

        checkBoxColumn.setCellValueFactory(new PropertyValueFactory<>("checkBox"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        progressColumn.setCellValueFactory(new PropertyValueFactory<>("progressIndicator"));

        getColumns().addAll(checkBoxColumn, authorColumn, titleColumn, progressColumn);
    }




}
