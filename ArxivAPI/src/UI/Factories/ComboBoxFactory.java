package UI.Factories;

import ArxivClient.ArxivAPI.Field.BoolFlag;
import UI.Stylesheet.StyleSheet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class ComboBoxFactory {

    public static ComboBox<PrefixID> prefixBox() {
        ComboBox<PrefixID> comboBox = getStyled("search-row-prefix-box");
        ObservableList<PrefixID> values =
                FXCollections.observableArrayList(PrefixID.values());
        comboBox.setItems(values);
        //Default Value
        comboBox.setValue(PrefixID.all);

        //TODO: Move to CSS stylesheet
        comboBox.setPrefSize(174,35);


        return comboBox;
    }

    public static ComboBox<BoolFlag> boolFlag() {
        ComboBox<BoolFlag> comboBox = getStyled("search-row-bool-flag");
        ObservableList<BoolFlag> values =
                FXCollections.observableArrayList(BoolFlag.AND, BoolFlag.OR, BoolFlag.NOT);
        comboBox.setItems(values);

        //Default Value
        comboBox.setValue(BoolFlag.OR);

        //TODO: Move to CSS stylesheet
        comboBox.setPrefSize(80,35);
        comboBox.setMinSize(80,35);

        return comboBox;
    }

    public static <T> ComboBox<T> getStyled(String styleName) {
        ComboBox<T> comboBox = new ComboBox();
        comboBox.getStylesheets().add(StyleSheet.get());
        comboBox.getStyleClass().add(styleName);
        return comboBox;
    }
}
