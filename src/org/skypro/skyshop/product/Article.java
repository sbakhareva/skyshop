package org.skypro.skyshop.product;

import org.skypro.skyshop.SearchEngine;
import org.skypro.skyshop.Searchable;

import java.util.Objects;

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

    @Override
    public String getSearchTerm() {
        return title + text;
    }

    @Override
    public String getObjName() {
        return this.title;
    }

    @Override
    public String getType() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
