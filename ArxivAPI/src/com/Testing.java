package com;

import com.Network.ArxivManager;
import com.Network.Search.Parameters.Field.BoolFlag;
import com.Network.Search.Parameters.Field.Field;
import com.Network.Search.Parameters.Field.Prefix.PrefixID;
import com.Network.Search.Parameters.MaxResult;
import com.Network.Search.Parameters.SearchQuery;
import com.Network.Search.Parameters.Start;
import com.Network.Search.SearchRequest;

public class Testing {

    public static void Field() {

        //The same functions
        Field field = new Field(PrefixID.author,"Akbarov");
//        field = new Field(PrefixID.all, "Akbarov");
        field.addAll("Akbarov", BoolFlag.UNDEFINED);
        field.add(PrefixID.all, "Akbarov", BoolFlag.UNDEFINED);

        //Adding addition values
        field.add(PrefixID.title, "Mathematical analysis", BoolFlag.AND);
        //Or
        //field.addTitle("Mathematical analysis", BoolFlag.AND);

        SearchQuery query = new SearchQuery(field);
        SearchRequest request = new SearchRequest(query);
        request.setMaxResult(new MaxResult(5));
        request.setStart(new Start(0));

        System.out.println(request.getUrl().toString());
        ArxivManager.makeSearch(request);

    }
}
