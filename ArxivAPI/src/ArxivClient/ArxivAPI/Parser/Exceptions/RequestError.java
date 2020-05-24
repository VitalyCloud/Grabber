package ArxivClient.ArxivAPI.Parser.Exceptions;

public class RequestError extends ParseException {
    public RequestError(String msg) {
        super("Error in request:\n" + msg);
    }
}
