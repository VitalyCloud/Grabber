package com.ArxivAPI.Search;


import com.Network.Request;
import com.ArxivAPI.Search.Parameters.IdList;
import com.ArxivAPI.Search.Parameters.MaxResult;
import com.ArxivAPI.Search.Parameters.SearchQuery;
import com.ArxivAPI.Search.Parameters.Start;
import java.net.URL;


public class SearchRequest implements Request {


    private final String name = "http://export.arxiv.org/api/query?";


    //Parameters
    private SearchQuery searchQuery;
    private MaxResult maxResult;
    private Start start;
    private IdList idList;
    // TODO: Implement sortBy and sortOrder Parameters

    /* Constructors */

    public SearchRequest() {}

    public SearchRequest(SearchQuery query) {
        searchQuery = query;
    }

    /* --------------------------------------------- */

    //Making URL string
    private String makeURLString() {
        String result = name;
        if(searchQuery != null)
            result+= searchQuery.getBody();
        else
            return "";

        if(idList != null) {
            // TODO: Implement IDList
        }

        if(start != null)
            result+= "&" + start.getBody();

        if(maxResult !=null)
            result+= "&" + maxResult.getBody();

        return result;
    }

    /* Request interface */

    //Can be null
    @Override
    public URL getUrl() {
        String sUrl = makeURLString();
        if(sUrl == null) {
            return null;
        }
        try {
            URL url = new URL(sUrl);
            return url;
        } catch (Exception ex) {
            System.out.println("Error while getUrl in SearchRequest");
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public String getAbsoluteString() {
        return makeURLString();
    }

    /* --------------------------------------------- */


    /* Getters and Setters* */
    public SearchQuery getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(SearchQuery searchQuery) {
        this.searchQuery = searchQuery;
    }

    public MaxResult getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(MaxResult maxResult) {
        this.maxResult = maxResult;
    }

    public Start getStart() {
        return start;
    }

    public void setStart(Start start) {
        this.start = start;
    }

    public IdList getIdList() {
        return idList;
    }

    public void setIdList(IdList idList) {
        this.idList = idList;
    }

    /* --------------------------------------------- */
}
