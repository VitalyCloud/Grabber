package ArxivClient.Network.Download;

import java.io.IOException;
import java.net.Authenticator;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class DownloadConnection {

    //TODO:: Test this bullshit

    private static Proxy proxy;
    private static Authenticator authenticator;

    public URLConnection openConnection(URL url) throws IOException {
        System.out.println("Opening connection...");
        URLConnection urlConnection;
        if(proxy!=null) {
            System.out.println("Proxy provided");
            if(authenticator!= null) {
                Authenticator.setDefault(authenticator);
            }
            urlConnection = url.openConnection(proxy);
            System.out.println("Connection opened via proxy");
        } else {
            System.out.println("Proxy is not provided");
            urlConnection =  url.openConnection();
            System.out.println("Connection opened");
        }

        return urlConnection;
    }


    //Setters
    public static void setProxy(Proxy proxy) {
        DownloadConnection.proxy = proxy;
    }
    public static void setAuthenticator(Authenticator authenticator) {
        DownloadConnection.authenticator = authenticator;
    }
}
