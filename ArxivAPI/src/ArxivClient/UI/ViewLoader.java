package ArxivClient.UI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.MalformedURLException;

public class ViewLoader<T> {
    public static final String VIEWS_PATH = "/ArxivClient/UI/MainView/";
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
    T controller;

    public ViewLoader(String fileName) {
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource(VIEWS_PATH + fileName));
            parent = fxmlLoader.load();
            controller = fxmlLoader.getController();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            error = e;
        } catch (IOException e) {
            e.printStackTrace();
            error = e;
        }
        this.fileName = fileName;
    }

    public Parent getParent() {
        return parent;
    }

    public T getController() {
        return controller;
    }

    public Exception getError() {
        return error;
    }
}
