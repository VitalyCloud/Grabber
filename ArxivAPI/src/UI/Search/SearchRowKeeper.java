package UI.Search;

import ArxivClient.ArxivAPI.Search.Field.BoolFlag;
import ArxivClient.ArxivAPI.Search.Field.Field;
import ArxivClient.ArxivAPI.Search.Field.Prefix.PrefixID;
import ArxivClient.ArxivAPI.Search.Parameters.SearchQuery;
import javafx.scene.layout.Pane;

import java.util.ArrayList;


public class SearchRowKeeper {

    Pane pane;
    SearchRow firstRow;
    ArrayList<SearchRow> searchRows; //TODO: test this

    SearchRowKeeper(Pane pane) {
        this.pane = pane;
        firstRow = new SearchRow();
        searchRows = new ArrayList<>();

        firstRow.setActionButtonState(true);
        pane.getChildren().add(firstRow.getPane());
        searchRows.add(firstRow);
        firstRow.getActionButton().setOnAction(e -> addRow(firstRow));
        firstRow.getBoolFlag().setVisible(false);
    }

    public SearchQuery getSearchQuery() {
        Field field = new Field();
        searchRows.forEach( searchRow -> {
            String text = searchRow.getTextField().getText();
            if(!text.isEmpty()) {
                BoolFlag boolFlag = searchRow.getBoolFlag().getValue();
                PrefixID prefix = searchRow.getPrefix().getValue();
                field.add(prefix, text, boolFlag);
            }
        });
        SearchQuery searchQuery = new SearchQuery(field);
        return searchQuery;
    }



    private void addRow(SearchRow caller) {
        if(caller.getActionButtonState()) {
            SearchRow searchRow = new SearchRow();
            searchRow.getActionButton().setOnAction(e -> addRow(searchRow));
            pane.getChildren().add(searchRow.getPane());
            searchRows.add(searchRow); //TODO: test this
            caller.setActionButtonState(false);
        } else {
            pane.getChildren().remove(caller.getPane());
            searchRows.remove(caller); //TODO: test this
        }

        hideBoolAtFirstRow();
    }

    private void hideBoolAtFirstRow() {
        SearchRow first = searchRows.get(0);
        if(first!=null) {
            first.getBoolFlag().setValue(BoolFlag.UNDEFINED);
            first.getBoolFlag().setVisible(false);
        }
    }

}
