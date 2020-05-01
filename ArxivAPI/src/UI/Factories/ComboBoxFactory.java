package UI.Factories;

import UI.Stylesheet.StyleSheet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class ComboBoxFactory {

    public static ComboBox<String> boolFlag() {
        ComboBox<String> comboBox = getStyled("search-row-bool-flag");
        ObservableList<String> values =
                FXCollections.observableArrayList("AND", "OR", "NOT");
        comboBox.setItems(values);

        //TODO: Move to CSS stylesheet
        comboBox.setPrefSize(80,35);
        comboBox.setMinSize(80,35);

        return comboBox;
    }

    public static ComboBox<String> prefixBox() {
        ComboBox<String> comboBox = getStyled("search-row-prefix-box");
        ObservableList<String> values =
                FXCollections.observableArrayList("All", "Title", "Author");
        comboBox.setItems(values);
        //TODO: Move to CSS stylesheet
        comboBox.setPrefSize(174,35);

        return comboBox;
    }


    public static <T> ComboBox<T> getStyled(String styleName) {
        ComboBox<T> comboBox = new ComboBox();
        comboBox.getStylesheets().add(StyleSheet.get());
        comboBox.getStyleClass().add(styleName);
        return comboBox;
    }
}
