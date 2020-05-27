package ArxivClient.UI.SearchView;

import ArxivClient.ArxivAPI.Field.BoolFlag;
import ArxivClient.ArxivAPI.Field.SearchField;
import ArxivClient.ArxivAPI.Prefix.Prefix;
import ArxivClient.ArxivAPI.Prefix.PrefixID;
import ArxivClient.ArxivAPI.SearchRequest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;


public class SearchRowHandler {

    private Pane pane;

    private ObservableList<SearchRow> searchRows;

    SearchRowHandler(Pane pane) {
        this.pane = pane;
        searchRows = FXCollections.observableArrayList();

        SearchRow firstRow = new SearchRow();
        firstRow.setActionButtonState(true);
        pane.getChildren().add(firstRow);
        searchRows.add(firstRow);
        firstRow.getActionButton().setOnAction(e -> addRow(firstRow));
        firstRow.getBoolFlagBox().setVisible(false);
    }

    public SearchRequest getSearchRequest() {
        SearchField field = new SearchField();
        searchRows.forEach( searchRow -> {
            String text = searchRow.getTextField().getText();
            if(!text.isEmpty()) {
                BoolFlag boolFlag = searchRow.getBoolFlagBox().getValue();
                PrefixID prefix = searchRow.getPrefixBox().getValue();
                field.add(new Prefix(prefix, text), boolFlag);
            }
        });
        SearchRequest searchQuery = new SearchRequest(field);
        return searchQuery;
    }

    private void addRow(SearchRow caller) {
        if(caller.getActionButtonState()) {
            SearchRow searchRow = new SearchRow();
            searchRow.getActionButton().setOnAction(e -> addRow(searchRow));
            pane.getChildren().add(searchRow);
            searchRows.add(searchRow);
            caller.setActionButtonState(false);
        } else {
            pane.getChildren().remove(caller);
            searchRows.remove(caller);
        }

        hideBoolAtFirstRow();
    }

    private void hideBoolAtFirstRow() {
        SearchRow first = searchRows.get(0);
        if(first!=null) {
            first.getBoolFlagBox().setVisible(false);
        }
    }

    public ObservableList<SearchRow> getSearchRows() {
        return searchRows;
    }
}
