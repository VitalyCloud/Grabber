package ArxivClient.Network.Iterfaces.Handlers;

public interface GETRequestCompletion<T> {
    public void complete(T data, Throwable error);
}
