package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Objects;

public class ProductBasket {
    private final Product[] basket = new Product[5];
    private static int special = 0;

    public void addProduct(Product product) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public int countSpecial() {
        for (Product product : basket) {
            if (product != null && product.isSpecial()) {
                special++;
            }
        }
        return special;
    }

    public int calculateCost() {
        int result = 0;
        for (Product product : basket) {
            if (product != null) {
                result += product.getPrice();
            }
        }
        return result;
    }

    public void printBasket() {
        boolean empty = true;
        for (Product product : basket) {
            if (product != null) {
                System.out.println(product);
                empty = false;
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
        for (Product product : basket) {
            if (name == null) {
                return false;
            }
            if (product != null && Objects.equals(product.getName(), name)) {
                return true;
            }
        }
        return false;
    }

    public void emptyBasket() {
        for (int i = 0; i < basket.length; i++) {
            basket[i] = null;
        }
        special = 0;
    }
}