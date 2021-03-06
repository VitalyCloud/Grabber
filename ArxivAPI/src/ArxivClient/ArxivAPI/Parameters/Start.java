package ArxivClient.ArxivAPI.Parameters;

public class Start implements AParameter {

    private final String parameterName = "start=";
    private int value;

    public Start(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return parameterName;
    }

    @Override
    public String getBody() {
        return getName()+value;
    }
}
