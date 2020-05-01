package UI.Search;

import javafx.scene.layout.HBox;
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
        firstRow.getActionButton().setOnAction(e -> addRow(firstRow));
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
        //Hide boolFlag for first row
        HBox first = (HBox) pane.getChildren().get(0);
        if(first != null) {
            first.getChildren().get(0).setVisible(false);
        }
    }

}
