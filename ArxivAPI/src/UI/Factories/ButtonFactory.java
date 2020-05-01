package UI.Factories;

import UI.Stylesheet.StyleSheet;
import javafx.scene.control.Button;

public class ButtonFactory {

    public static Button menuButton(String name) {
        Button button = getStyled("menu-button");
        button.setText(name);

        return button;
    }

    public static Button searchRowActionButton() {
        Button button = getStyled("search-row-action-button");
        button.setText("+");

        //TODO: Move to stylesheet
        button.setPrefSize(31,35);

        return button;
    }

    public static Button getStyled(String styleName) {
        Button button = new Button();
        button.getStylesheets().add(StyleSheet.get());
        button.getStyleClass().add(styleName);

        return button;
    }
}
