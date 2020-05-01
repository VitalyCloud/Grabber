package UI.Factories;

import UI.Stylesheet.StyleSheet;
import javafx.scene.control.TextField;

public class TextFieldFactory {

    public static TextField searchFieldOnSearchWindow() {
        TextField textField = new TextField();

        textField.getStylesheets().add(StyleSheet.get());
        textField.getStyleClass().add("search-row-search-field");

        //TODO: Move to CSS stylesheet
        textField.setPromptText("Search item...");
        textField.setPrefSize(389,35);

        return textField;
    }
}
