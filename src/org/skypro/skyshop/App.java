package org.skypro.skyshop;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // exceptions();
        searching();
        /*Searchable[] searchEngine = new Searchable[5]; // Создание массива для хранения объектов Searchable
        searchEngine[0] = new SimpleProduct("ff", 17);
        searchEngine[1] = new DiscountedProduct("eee", 50, 50);
        searchEngine[2] = new FixPriceProduct("aaaaaaaafff");
        searchEngine[3] = new Article("Rte", "bcd");
        searchEngine[4] = new Article("Wqr", "pol");

        String searchTerm = "f"; // Подстрока для поиска (можно изменить на нужную)
        int countSubstringLast = 0; // Переменная для хранения предыдущего значения счетчика
        int resultIndex = -1; // Индекс объекта Searchable с наибольшим количеством вхождений

        for (int i = 0; i < searchEngine.length; i++) {
            if (searchEngine[i] != null) {
                String searchContent = searchEngine[i].getSearchTerm().toLowerCase().replace(" ", ""); // Приведение к нижнему регистру и удаление пробелов
                int count = 0;
                int fromIndex = 0;

                while ((fromIndex = searchContent.indexOf(searchTerm.toLowerCase(), fromIndex)) != -1) {
                    count++;
                    fromIndex += searchTerm.length();
                }

                if (count > countSubstringLast) {
                    countSubstringLast = count;
                    resultIndex = i;
                }
            }
        }

        if (resultIndex != -1) {
            System.out.println("Объект с наибольшим количеством вхождений подстроки: " + searchEngine[resultIndex]);
        } else {
            System.out.println("Подстрока не найдена в объектах Searchable.");
        }

         */

    }

    public static void searching() {
        SearchEngine searchable = new SearchEngine(5);

        Article article = new Article("Омлет с ветчиной", "Приготовлен из яиц и ветчины."); // проверяю как работает добавление статьи

        searchable.add(article);
        searchable.add(new Article("Заголовок", "Текст"));
        searchable.add(new SimpleProduct("Сметана сметана", 120));
        searchable.add(new DiscountedProduct("Сметана", 98, 20));
        searchable.add(new FixPriceProduct("Крем для рук"));

        try {
            searchable.getBestMatch("а");
        } catch (BestResultNotFound e) {
            System.out.println("Поиск не дал результата.");
        }
        try {
            searchable.getBestMatch("Молоко");
        } catch (BestResultNotFound e) {
            System.out.println("Поиск не дал результата.");
        }
    }

    public static void inheritance() {
        ProductBasket basket = new ProductBasket();

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
    }

    public static void exceptions() {
        try {
            Product product1 = new SimpleProduct("        ", 50);
            System.out.println(product1);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("Название не может быть пустым!");
        }

        try {
            SimpleProduct simpleProduct = new SimpleProduct("a", -1);
            System.out.println(simpleProduct);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("Цена не может быть меньше или равна нулю!");
        }

        try {
            DiscountedProduct discountedProduct = new DiscountedProduct("a", -1, 101);
            System.out.println(discountedProduct);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("Неверное значение цены и/или скидки! Цена не может быть меньше или равна нулю. Скидка не может быть меньше 0% или больше 100%");
        }
    }
}
