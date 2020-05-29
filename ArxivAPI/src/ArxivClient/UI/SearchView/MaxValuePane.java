package ArxivClient.UI.SearchView;

import javafx.scene.control.Label;

public class MaxValuePane extends SpinnerPane {

    public MaxValuePane() {
        super(1, 100, 10);
        setRightLabel(new Label("Max value"));
    }
}
