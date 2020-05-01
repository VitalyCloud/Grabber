package com.ArxivAPI.Article;

public class Author {
    public String name;
    public String affiliation;
    public Author() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public void print(){
        System.out.println("Author:");
        System.out.println("\tname: " + name);
        System.out.println("\taffiliation: " + affiliation);
    }
}