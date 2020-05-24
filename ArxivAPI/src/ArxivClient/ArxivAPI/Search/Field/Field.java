package ArxivClient.ArxivAPI.Search.Field;

import ArxivClient.ArxivAPI.Search.Field.Prefix.PrefixFactory;
import ArxivClient.ArxivAPI.Search.Field.Prefix.PrefixID;
import ArxivClient.ArxivAPI.Search.Field.Prefix.Prefix;

import java.util.ArrayList;
import java.util.HashMap;

public class Field {

    HashMap<Prefix, BoolFlag> prefixesProperty;
    protected ArrayList<Prefix> prefixList;
    private PrefixFactory prefixFactory;

    public Field() {
        this.prefixList = new ArrayList<>();
        this.prefixFactory = new PrefixFactory();
        this.prefixesProperty = new HashMap<>();
    }

    public Field(PrefixID id, String value) {
        this.prefixList = new ArrayList<>();
        this.prefixFactory = new PrefixFactory();
        this.prefixesProperty = new HashMap<>();
        Prefix prefix = prefixFactory.forID(id, value);
        add(prefix, BoolFlag.UNDEFINED);
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

    public String getBody() {
        return getPrefixesBody();
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

    /* Easy use adding fields */

    public void add(PrefixID id, String value, BoolFlag flag) {
        Prefix prefix = prefixFactory.forID(id, value);
        add(prefix, flag);
    }

    public void addAuthor(String value, BoolFlag flag) {
        add(prefixFactory.author(value), flag);
    }

    public void addTitle(String value, BoolFlag flag) {
        add(prefixFactory.title(value), flag);
    }

    public void addAbstract(String value, BoolFlag flag) {
        add(prefixFactory._abstract(value), flag);
    }

    public void addComment(String value, BoolFlag flag) {
        add(prefixFactory.comment(value), flag);
    }

    public void addJournalReference(String value, BoolFlag flag) {
        add(prefixFactory.journalReference(value), flag);
    }

    public void addSubjectCategory(String value, BoolFlag flag) {
        // TODO: Implement interface for SubjectCategory
        add(prefixFactory.subjectCategory(value), flag);
    }

    public void addReportNumber(String value, BoolFlag flag) {
        add(prefixFactory.reportNumber(value), flag);
    }

    public void addID(String value, BoolFlag flag) {
        add(prefixFactory.id(value), flag);
    }

    public void addAll(String value, BoolFlag flag) {
        add(prefixFactory.all(value), flag);
    }

    /* --------------------------------------- */


}

