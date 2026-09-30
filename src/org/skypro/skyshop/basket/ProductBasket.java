package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> basket = new HashMap<>();

    public void addProduct(Product product) {
        basket.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    private long getSpecialCount() {
        return basket.values().stream().flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public int calculateCost() {
        return basket.values().stream().flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        basket.values().stream().flatMap(Collection::stream)
                .forEach(System.out::println);
        if (basket.isEmpty()) {
            System.out.println("B корзине пусто");
        } else {
            System.out.println("Итого: " + calculateCost());
            System.out.println("Специальных товаров: " + getSpecialCount());
        }
    }

    public boolean searchByName(String name) {
        return basket.containsKey(name);
    }

    public void emptyBasket() {
        basket.clear();
    }

    public List<Product> removeProduct(String name) {
        List<Product> result = basket.remove(name);
        if (result == null) {
            return new ArrayList<>();
        }
        return result;
    }
}