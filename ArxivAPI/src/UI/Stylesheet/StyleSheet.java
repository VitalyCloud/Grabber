package UI.Stylesheet;

public class StyleSheet {

    static String sheet = StyleSheet.class.getResource("stylesheet.css").toExternalForm();

    public static String get() {
        return sheet;
    }
}
