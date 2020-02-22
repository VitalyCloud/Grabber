package com;

import com.Network.NetworkSession;
import com.Network.Parser.ParserException;
import com.Network.Parser.ResponseParser;
import com.Network.Search.Parameters.Field.Field;
import com.Network.Search.Parameters.Field.Prefix.PrefixID;
import com.Network.Search.Parameters.MaxResult;
import com.Network.Search.Parameters.SearchQuery;
import com.Network.Search.Parameters.Start;
import com.Network.Search.SearchRequest;


import java.net.HttpURLConnection;


public class Testing {

    public static void Field() {

        //The same functions
        Field field = new Field(PrefixID.author,"Akbarov");

        SearchQuery query = new SearchQuery(field);

        SearchRequest request = new SearchRequest(query);
        request.setMaxResult(new MaxResult(1));
        request.setStart(new Start(0));
        System.out.println(request.getUrl().toString());


        NetworkSession networkSession = new NetworkSession();

        ResponseParser parser = new ResponseParser();

        networkSession.makeURLGETRequest(request, ((response, errorCode) -> {
            if(errorCode == HttpURLConnection.HTTP_OK) {
                try {
                    parser.parseSearchRequest(response);
                } catch (ParserException.RequestError error) {
                    error.printStackTrace();
                } catch (Exception other) {
                    other.printStackTrace();
                }
            }
        }));


    }



}
