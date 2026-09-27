package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

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

    public String getName() {
        return article;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Article)) return false;
        return Objects.equals(article, ((Article) o).article);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(article);
    }
}