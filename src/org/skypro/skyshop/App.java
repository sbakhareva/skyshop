package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Article article = new Article("Омлет с ветчиной", "Приготовлен из яиц и ветчины.");
        System.out.println(article);

        Product simpleProduct = new SimpleProduct("Омлет с ветчиной", 150);
        Product fixPriceProduct = new FixPriceProduct("Вафли ореховые");
        Product discountedProduct = new DiscountedProduct("Торт миндальный", 450, 40);

        basket.addProduct(simpleProduct); // обычный продукт
        basket.addProduct(fixPriceProduct); // продукт с фиксированной ценой
        basket.addProduct(discountedProduct); // уцененный продукт

        basket.countSpecials();

        System.out.println("Общая стоимость корзины: " + basket.calculateBasketCost() + " рублей");
        basket.printBasket();

        basket.isThereProduct("Творожный сырок"); // поиск товара, которого нет в корзине
        basket.isThereProduct("Омлет с ветчиной"); // поиск товара, который есть в корзине

        basket.clearBasket(); // очистка корзины
        basket.printBasket(); // печать пустой корзины
        System.out.println("Общая стоимость корзины: " + basket.calculateBasketCost() + " рублей."); // сумма пустой корзины
        basket.isThereProduct("Молоко цельное"); // поиск товара в пустой корзине

        final ProductBasket basket1 = new ProductBasket();

        basket1.addProduct(new SimpleProduct("Омлет с овощами", 150));
        basket1.addProduct(new SimpleProduct("Молоко цельное", 98));
        basket1.addProduct(new SimpleProduct("Вафли ореховые", 75));
        basket1.addProduct(new SimpleProduct("Торт миндальный", 450));
        basket1.addProduct(new SimpleProduct("Торт шоколадный", 250));
        basket1.addProduct(new SimpleProduct("Тирамису", 300)); // добавляю товар в заполненную корзину

        basket1.clearBasket();
    }
}
