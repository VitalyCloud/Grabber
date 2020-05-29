package ArxivClient.UI.SearchView;

import javafx.scene.control.Label;

public class StartAtPane extends SpinnerPane {

    public StartAtPane() {
        super(0, 100000, 0);
        setLeftLabel(new Label("Start at"));
    }

}
