package UI.Search;

import ArxivClient.ArxivAPI.Field.BoolFlag;
import UI.Factories.ButtonFactory;
import UI.Factories.ComboBoxFactory;
import UI.Factories.PrefixID;
import UI.Factories.TextFieldFactory;
import UI.Stylesheet.StyleSheet;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class SearchRow {
    private HBox pane;

    private TextField textField;
    private ComboBox<BoolFlag> boolFlag;
    private ComboBox<PrefixID> prefix;
    private Button actionButton;


    public SearchRow() {
        textField = TextFieldFactory.searchFieldOnSearchWindow();
        boolFlag = ComboBoxFactory.boolFlag();
        prefix = ComboBoxFactory.prefixBox();
        actionButton = ButtonFactory.searchRowActionButton();
        pane = new HBox();

        pane.getStylesheets().add(StyleSheet.get());
        pane.getStyleClass().add("search-row");
    }

    public TextField getTextField() {
        return textField;
    }

    public ComboBox<BoolFlag> getBoolFlag() {
        return boolFlag;
    }

    public ComboBox<PrefixID> getPrefix() {
        return prefix;
    }

    public Button getActionButton() {
        return actionButton;
    }

    public boolean getActionButtonState() {
        return actionButton.getText() == "+" ? true : false;
    }

    public boolean setActionButtonState(boolean state) {
        boolean currentState = getActionButtonState();
        actionButton.setText(state == true ? "+" : "-");
        return currentState;
    }

    private void config() {
        HBox paneForSearch = new HBox();
        paneForSearch.getChildren().addAll(textField, prefix, actionButton);
        pane.getChildren().addAll(boolFlag, paneForSearch);
    }

    private boolean isConfigured = false;
    public Pane getPane() {
        if(isConfigured == false){
            config();
            isConfigured = true;
        }
        return pane;
    }
}
