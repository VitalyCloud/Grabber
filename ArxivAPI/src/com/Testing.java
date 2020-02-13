package com;

import com.Network.Search.Field.AField;
import com.Network.Search.Field.ComposedField;
import com.Network.Search.Field.Field;
import com.Network.Search.Prefix.PAll;
import com.Network.Search.Prefix.PAuthor;
import com.Network.Search.Prefix.PTitle;
import com.Network.Search.SearchRequest;

public class Testing {

    public static void APrefix() {
        PAuthor author = new PAuthor(" Greg  Pavlenko      ");
        System.out.println(author.getBody());
        System.out.println(author.toString());

        PAuthor author1 = new PAuthor("Vetal");
        System.out.println(author1.getBody());
        System.out.println(author1.toString());

        PAuthor author2 = new PAuthor("1 Vetal   qweqwe   e    qweqw     q ewqeqw     ");
        System.out.println(author2.getBody());
        System.out.println(author2.toString());
    }

    public static void AField() {
        //        Field field = new Field();
//        field.add(new PAuthor("Vetal"));
//        field.add(new PId("123"));
//        field.add(new PComment("The best!"));
//        System.out.println(field.getBody());
//
//        Field field2 = new Field();
//        field2.add(new PAuthor("Gleb"));
//        field2.add(new PComment("Normas!"));
//        field2.setBoolFlag(AField.BoolFlag.ANDNOT);
//        System.out.println(field2.getBody());
//
//        ComposedField cmpField = new ComposedField();
//        cmpField.add(field);
//        cmpField.add(field2);
//        cmpField.add(new PJournalReference("00000"));
//        cmpField.setBoolFlag(AField.BoolFlag.AND);
//        System.out.println(cmpField.getBody());

        Field SField1 = new Field();
        SField1.add(new PAuthor("del_maestro"));

        Field SField2 = new Field();
        SField2.add(new PTitle("checkerboard"));
        SField2.setBoolFlag(AField.BoolFlag.OR);
        SField2.add(new PTitle(""));

        ComposedField cmp = new ComposedField();
        cmp.setBoolFlag(AField.BoolFlag.ANDNOT);
        cmp.add(SField1);
        cmp.add(SField2);

//        ComposedField cmp = new ComposedField();
//        cmp.setBoolFlag(AField.BoolFlag.ANDNOT);
//        cmp.add(new PTitle(""));
//        cmp.add(new PTitle("1231231"));
        System.out.println(cmp.getBody());
    }
    public static void searchRequest() {

        //        Field field = new Field();
//        field.add(new PAuthor("Sergei Akbarov"));
//        field.add(new PTitle("Mathematical analysis"));
//        field.setBoolFlag(AField.BoolFlag.AND);

        Field titles = new Field();
        titles.add(new PTitle("Mathematical analysis"));
        titles.add(new PTitle("Envelopes and refinements in categories, with applications to Functional" +
                " Analysis"));
        titles.add(new PTitle("Kernel and cokernel in the category of augmented involutive stereotype algebras"));
        titles.setBoolFlag(AField.BoolFlag.OR);

        ComposedField cfield = new ComposedField();
        cfield.add(titles);
        cfield.add(new PAll("Sergei Akbarov"));
        cfield.setBoolFlag(AField.BoolFlag.AND);

        SearchRequest request = new SearchRequest(cfield);
        System.out.println(cfield.getBody());

        try {
            request.perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
