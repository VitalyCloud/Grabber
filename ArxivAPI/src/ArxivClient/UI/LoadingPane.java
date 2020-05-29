package ArxivClient.UI;


import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;

public class LoadingPane extends VBox {

    private ProgressIndicator progressIndicator;
    private Label label;

    public LoadingPane() {
        progressIndicator = new ProgressIndicator();
        label = new Label("Sending request to http://export.arxiv.org/api/");
        configViewStyle();

        getChildren().addAll(progressIndicator, label);
    }

    private void configViewStyle() {
        setAlignment(Pos.CENTER);
        setSpacing(10);
    }

    public void startLoading() {
        label.setText("Sending request to http://export.arxiv.org/api/");
        progressIndicator.setProgress(-1.0);
    }

    public void stopLoading() {
        progressIndicator.setProgress(1.0);
        label.setText("Completed");
    }

    public void setMessage(String message) {
        label.setText(message);
    }
}
