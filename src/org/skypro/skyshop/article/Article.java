package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private final String article;
    private final String text;

    public Article(String article, String text) {
        this.article = article;
        this.text = text;
    }

    @Override
    public String toString() {
        return article + "\n" + text;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }
}