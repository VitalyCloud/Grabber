package com.Network.Search.Field;

import java.util.ArrayList;

public class ComposedField extends Field {

    ArrayList<Field> fields;

    public ComposedField() {
        super();
        fields = new ArrayList<>();
    }


    public void add(Field field) {
        fields.add(field);
    }

    public void remove(Field field) {
        fields.remove(field);
    }

    @Override
    public String getBody() {
        String result = "";
        String boolFlag = "+" + getBoolFlag().name() + "+";

        if(fields.isEmpty()) {
            return super.getBody();
        }

        if(fields.get(0).isSimple())
            result += fields.get(0).getBody();
         else
            result += "%28" + fields.get(0).getBody() + "%29";


        for(int i = 1; i< fields.size(); i++) {
            Field SField = fields.get(i);
            if(SField.isSimple())
                result += boolFlag  + SField.getBody();
            else
                result += boolFlag + "%28" + SField.getBody() + "%29";
        }

        if(!prefixes.isEmpty()) {
            result += boolFlag  + super.getBody();
        }

        return result;
    }
}
