package ArxivClient.UI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.concurrent.Executor;

public class ViewLoader {
    public static final String VIEWS_PATH = "/ArxivClient/UI/View/";
    public static Parent load(String name) {
        Parent root = null;
        try {
            root = FXMLLoader.load(ViewLoader.class.getResource(VIEWS_PATH + name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

    FXMLLoader fxmlLoader;
    String fileName;
    Parent parent;
    Exception error;

    public ViewLoader(String fileName) {
        fxmlLoader = new FXMLLoader();
        this.fileName = fileName;
    }

    public Parent getParent() {
        if(parent==null)
            try {
                    parent = fxmlLoader.load(getClass().getResource(VIEWS_PATH + fileName));
            } catch (Exception ex) {
                error = ex;
            }
        return parent;
    }

    public <T> T getController() {
        return fxmlLoader.getController();
    }

}
