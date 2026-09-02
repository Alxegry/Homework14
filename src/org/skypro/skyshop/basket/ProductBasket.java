package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ProductBasket {
    private final List<Product> basket = new LinkedList<>();

    public void addProduct(Product product) {
        basket.add(product);
    }

    public int countSpecial() {
        int i = 0;
        for (Product product : basket) {
            if (product != null && product.isSpecial()) {
                i++;
            }
        }
        return i;
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
        basket.clear();
    }

    public List<Product> removeProduct(String name) {
        List<Product> result = new LinkedList<>();
        Iterator<Product> it = basket.iterator();
        while (it.hasNext()) {
            Product element = it.next();
            if (element.getName().equals(name)) {
                result.add(element);
                it.remove();
            }
        }
        return result;
    }
}