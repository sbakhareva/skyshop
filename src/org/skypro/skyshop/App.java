package org.skypro.skyshop;

import org.skypro.skyshop.exceptions.IncorrectDiscountValueException;
import org.skypro.skyshop.exceptions.IncorrectPriceValueException;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        searching();

    }

    public static void searching() {
        SearchEngine searchable = new SearchEngine(5);

        Article article = new Article("Омлет с ветчиной", "Приготовлен из яиц и ветчины."); // проверяю как работает добавление статьи
        // System.out.println(article);

        searchable.add(new Article("Заголовок", "Текст"));
        searchable.add(new SimpleProduct("Яйца куриные", 120));
        searchable.add(new DiscountedProduct("Сметана", 98, 20));
        searchable.add(new FixPriceProduct("Крем для рук"));
        searchable.add(article);
        // System.out.println(searchable);

        // System.out.println(Arrays.toString(searchable.search("Омлет")));
        // System.out.println(Arrays.toString(searchable.search("Яйца")));
        System.out.println(Arrays.toString(searchable.getBestMatch("Омлет")));
        System.out.println(Arrays.toString(searchable.getBestMatch("Молоко")));
    }

    public static void inheritance() {
        ProductBasket basket = new ProductBasket();

        Product simpleProduct = new SimpleProduct("Омлет с ветчиной", 150);
        Product fixPriceProduct = new FixPriceProduct("Вафли ореховые");
        // Product discountedProduct = new DiscountedProduct("Торт миндальный", 450, 40);

        basket.addProduct(simpleProduct); // обычный продукт
        basket.addProduct(fixPriceProduct); // продукт с фиксированной ценой
        // basket.addProduct(discountedProduct); // уцененный продукт

        basket.countSpecials();

        System.out.println("Общая стоимость корзины: " + basket.calculateBasketCost() + " рублей");
        basket.printBasket();

        basket.isThereProduct("Творожный сырок"); // поиск товара, которого нет в корзине
        basket.isThereProduct("Омлет с ветчиной"); // поиск товара, который есть в корзине

        basket.clearBasket(); // очистка корзины
        basket.printBasket(); // печать пустой корзины
        System.out.println("Общая стоимость корзины: " + basket.calculateBasketCost() + " рублей."); // сумма пустой корзины
        basket.isThereProduct("Молоко цельное"); // поиск товара в пустой корзине
    }

    public static void exceptions() {
        // проверяю проверку на пустое название
        try {
            Product product1 = new SimpleProduct("        ", 50);
            System.out.println(product1);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("Название не может быть пустым!");
        }

        // проверка на цену меньше нуля
        try {
            SimpleProduct simpleProduct = new SimpleProduct("a", -1);
            System.out.println(simpleProduct);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("Цена не может быть меньше или равна нулю!");
        }

        // проверка на цену и скидку
        // хотела сделать два разных исключения здесь и даже создала свои новые, но джава хочет,
        // чтобы я обработала их везде, где есть объект DiscountedProduct,
        // можно ли поместить обработку непосредственно в класс DiscountedProduct?
        try {
            DiscountedProduct discountedProduct = new DiscountedProduct("a", -1, 101);
            System.out.println(discountedProduct);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("Неверное значение цены и/или скидки! Цена не может быть меньше или равна нулю. Скидка не может быть меньше 0% или больше 100%");
        }
    }
}
