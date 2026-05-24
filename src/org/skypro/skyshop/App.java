package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product pr1 = new Product("name1", 15);
        Product pr2 = new Product("name2", 15);
        Product pr3 = new Product("name3", 15);
        Product pr4 = new Product("name4", 15);
        Product pr5 = new Product("name5", 15);
        Product pr6 = new Product("name6", 15);
        ProductBasket basket = new ProductBasket();
        basket.addProduct(pr1);
        basket.addProduct(pr2);
        basket.addProduct(pr3);
        basket.addProduct(pr4);
        basket.addProduct(pr5);
        basket.addProduct(pr6);
        basket.printBasket();
        System.out.println(basket.calculateCost());
        System.out.println(basket.searchByName("name1"));
        System.out.println(basket.searchByName("name6"));
        basket.emptyBasket();
        basket.printBasket();
        System.out.println(basket.calculateCost());
        System.out.println(basket.searchByName("name1"));
    }
}