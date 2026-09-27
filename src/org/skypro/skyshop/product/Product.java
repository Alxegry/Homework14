package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустой строкой или null");
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getTypeContent() {
        return "PRODUCT";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product)) return false;
        return Objects.equals(name, ((Product) o).name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}