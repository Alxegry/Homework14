package org.skypro.skyshop;

import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.SearchEngine;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Product pr1 = new SimpleProduct("name1", 15);
        Product pr2 = new DiscountedProduct("name2", 100, 20);
        Product pr3 = new DiscountedProduct("name3", 200, 20);
        Product pr4 = new FixPriceProduct("name4");
        Product pr5 = new FixPriceProduct("name5");
        Product pr6 = new SimpleProduct("name6", 15);
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
        SearchEngine archive = new SearchEngine(10);
        archive.add(pr1);
        archive.add(pr2);
        archive.add(pr3);
        archive.add(pr4);
        archive.add(pr5);
        archive.add(pr6);
        Article pr7 = new Article("article1", "name1");
        Article pr8 = new Article("article2", "name2");
        Article pr9 = new Article("article3", "name3");
        archive.add(pr7);
        archive.add(pr8);
        archive.add(pr9);
        System.out.println(Arrays.toString(archive.search("name")));
        System.out.println(Arrays.toString(archive.search("article")));
        System.out.println(Arrays.toString(archive.search("name3")));
    }
}