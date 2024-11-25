package org.skypro.skyshop.article;

public class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return this.title;
    }

    public String getText() {
        return this.text;
    }
    public String toString() {
        return title + "\n" + text;
    }

    public String getSearchTerm() {
        return toString();
    }

    public String getType() {
        return "ARTICLE";
    }
}

interface Searchable {
    default String getSearchTerm() {
        return this.getSearchTerm();
    }

    default String getType(){
        return this.getType();
    }

    default String getObjName() {
        return this.getObjName();
    }

    default String getStringRepresentation() {
        return  "Объект " + getObjName() + " типа " + getType();
    }
}
