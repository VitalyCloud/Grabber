package com.Network.Search.Field;

import com.Network.Search.Prefix.APrefix;
import java.util.ArrayList;

public class Field extends AField {
    protected ArrayList<APrefix> prefixes;

    public Field() {
        super();
        prefixes = new ArrayList<>();
    }

    public void add(APrefix prefix) {
        if(!prefix.toString().isEmpty())
            prefixes.add(prefix);
    }

    public boolean isSimple() {
        return prefixes.size()==1;
    }

    public void remove(APrefix prefix) {
        prefixes.remove(prefix);
    }

    @Override
    public String getBody() {
        String result = "";
        if(prefixes.isEmpty()) {
            return "";
        }

        result = prefixes.get(0).getBody();

        for(int i=1; i<prefixes.size(); i++) {
            result += "+" + getBoolFlag().name() + "+";
            result += prefixes.get(i).getBody();
        }

        return result;
    }
}

