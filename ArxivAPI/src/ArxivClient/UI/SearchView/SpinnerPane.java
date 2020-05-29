package ArxivClient.UI.SearchView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;

public class SpinnerPane extends HBox{
    Spinner<Integer> spinner;
    SpinnerValueFactory<Integer> spinnerValueFactory;

    Label left, right;


    public SpinnerPane(int min, int max, int def) {
        spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(min, max, def);
        spinner = new Spinner<>();
        spinner.setEditable(true);
        spinner.setValueFactory(spinnerValueFactory);

        getChildren().addAll(spinner);
        configViewStyle();
    }

    public void setLeftLabel(Label label) {
        if(left!=null)
            getChildren().remove(left);
        left = label;
        getChildren().add(0, label);
    }

    public void setRightLabel(Label label) {
        if(right != null)
            getChildren().remove(right);
        right = label;
        getChildren().add(right);
    }

    public int getValue() {
        return spinnerValueFactory.getValue();
    }

    public void setValue(int value) {
        spinnerValueFactory.setValue(value);
    }

    private void configViewStyle() {
        setAlignment(Pos.CENTER);
        setPadding(new Insets(10, 0, 10, 0));
        setSpacing(5);
    }
}
