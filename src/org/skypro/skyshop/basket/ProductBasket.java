package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> basket = new HashMap<>();

    public void addProduct(Product product) {
        basket.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int countSpecial() {
        int i = 0;
        for (List<Product> productList : basket.values()) {
            for (Product product : productList) {
                if (product != null && product.isSpecial()) {
                    i++;
                }
            }
        }
        return i;
    }

    public int calculateCost() {
        int result = 0;
        for (List<Product> productList : basket.values()) {
            for (Product product : productList) {
                if (product != null) {
                    result += product.getPrice();
                }
            }
        }
        return result;
    }

    public void printBasket() {
        boolean empty = true;
        for (List<Product> productList : basket.values()) {
            for (Product product : productList) {
                if (product != null) {
                    System.out.println(product);
                    empty = false;
                }
            }
        }
        if (empty) {
            System.out.println("B корзине пусто");
        } else {
            System.out.println("Итого: " + calculateCost());
            System.out.println("Специальных товаров: " + countSpecial());
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