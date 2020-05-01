package UI.Search;

import UI.Factories.ButtonFactory;
import UI.Stylesheet.StyleSheet;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;

public class SearchButtonRow extends HBox {
    private Button button;

    SearchButtonRow() {
        super();
        button = ButtonFactory.getStyled("search-window-search-button");
        button.setText("Search");

        getStylesheets().add(StyleSheet.get());
        getStyleClass().add("search-window-search-button-pane");

        //TODO: Move to stylesheet
        button.setMinSize(183,46);

        getChildren().add(button);
    }

    public Button getButton() {
        return button;
    }
}
