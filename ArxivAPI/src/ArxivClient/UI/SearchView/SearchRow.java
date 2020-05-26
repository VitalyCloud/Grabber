package ArxivClient.UI.SearchView;


import ArxivClient.ArxivAPI.Field.BoolFlag;
import ArxivClient.ArxivAPI.Prefix.PrefixID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.Collections;


public class SearchRow extends HBox {

    private TextField textField;
    private ComboBox<BoolFlag> boolFlagBox;
    private ComboBox<PrefixID> prefixBox;
    private Button actionButton;


    public SearchRow() {

        textField = new TextField();
        boolFlagBox = new ComboBox<>();
        prefixBox = new ComboBox<>();
        actionButton = new Button("+");
        config();
    }

    public boolean setActionButtonState(boolean state) {
        boolean currentState = getActionButtonState();
        actionButton.setText(state == true ? "+" : "-");
        return currentState;
    }

    private void config() {
        HBox paneForSearch = new HBox();
        paneForSearch.getChildren().addAll(textField, prefixBox, actionButton);
        getChildren().addAll(boolFlagBox, paneForSearch);
        setAlignment(Pos.CENTER);

        ObservableList<PrefixID> prefixList = FXCollections.observableArrayList();
        prefixList.addAll(PrefixID.values());
        prefixBox.setItems(prefixList);
        prefixBox.setValue(PrefixID.all);

        ObservableList<BoolFlag> boolFlags = FXCollections.observableArrayList();
        boolFlags.addAll(BoolFlag.OR, BoolFlag.AND, BoolFlag.NOT);
        boolFlagBox.setItems(boolFlags);
        boolFlagBox.setValue(BoolFlag.OR);

    }


    public TextField getTextField() {
        return textField;
    }

    public ComboBox<BoolFlag> getBoolFlagBox() {
        return boolFlagBox;
    }

    public ComboBox<PrefixID> getPrefixBox() {
        return prefixBox;
    }

    public Button getActionButton() {
        return actionButton;
    }

    public boolean getActionButtonState() {
        return actionButton.getText() == "+" ? true : false;
    }
}
