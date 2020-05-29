package ArxivClient.ArxivAPI.Field;

//import ArxivClient.ArxivAPI.Prefix.PrefixID;
import ArxivClient.ArxivAPI.Parameters.AParameter;
import ArxivClient.ArxivAPI.Prefix.Prefix;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchField implements AParameter {

    private final String paramenterName = "search_query=";
    private HashMap<Prefix, BoolFlag> prefixesProperty;
    protected ArrayList<Prefix> prefixList;

    public SearchField() {
        this.prefixList = new ArrayList<>();
        this.prefixesProperty = new HashMap<>();
    }

    /* Добавление и удаление префиксов и полей*/

    public void add(Prefix prefix, BoolFlag flag) {
        if(!prefix.toString().isEmpty()) {
            if(flag == BoolFlag.UNDEFINED) {
                if(!prefixList.isEmpty()) {
                    Prefix forDelete = prefixList.get(0);
                    if(forDelete != null)
                        prefixesProperty.remove(forDelete);
                    prefixList.set(0, prefix);
                } else {
                    prefixList.add(prefix);
                }
            } else {
                prefixList.add(prefix);
            }
            prefixesProperty.put(prefix, flag);
        }
    }

    public void remove(Prefix prefix) {
        prefixList.remove(prefix);
        prefixesProperty.remove(prefix);
    }

    /* --------------------------------------- */

    @Override
    public String getName() {
        return paramenterName;
    }

    public String getBody() {
        return getName() + getPrefixesBody();
    }

    /* --------------------------------------- */

    private String getPrefixesBody() {
        String result = "";
        if(prefixList.isEmpty()) {
            return "";
        }

        result = prefixList.get(0).getBody();

        for(int i = 1; i< prefixList.size(); i++) {
            Prefix prefix = prefixList.get(i);
            result += "+" + prefixesProperty.get(prefix) + "+";
            result += prefix.getBody();
        }

        return result;
    }

    /* --------------------------------------- */


}

