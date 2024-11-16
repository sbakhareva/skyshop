package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new Product("Омлет с ветчиной", 150));
        basket.addProduct(new Product("Молоко цельное", 98));
        basket.addProduct(new Product("Вафли ореховые", 75));
        basket.addProduct(new Product("Торт миндальный", 450));

        System.out.println("Общая стоимость корзины: " + basket.calculateBasketCost() + " рублей");
        basket.printBasket();

        basket.isThereProduct("Творожный сырок"); // поиск товара, которого нет в корзине
        basket.isThereProduct("Омлет с ветчиной"); // поиск товара, который есть в корзине

        basket.clearBasket(); // очистка корзины
        basket.printBasket(); // печать пустой корзины
        System.out.println("Общая стоимость корзины: " + basket.calculateBasketCost() + " рублей."); // сумма пустой корзины
        basket.isThereProduct("Молоко цельное"); // поиск товара в пустой корзине

        ProductBasket basket1 = new ProductBasket();

        basket1.addProduct(new Product("Омлет с овощами", 150));
        basket1.addProduct(new Product("Молоко цельное", 98));
        basket1.addProduct(new Product("Вафли ореховые", 75));
        basket1.addProduct(new Product("Торт миндальный", 450));
        basket1.addProduct(new Product("Торт шоколадный", 250));
        basket1.addProduct(new Product("Тирамису", 300)); // добавляю товар в заполненную корзину

        basket1.clearBasket();
    }
}
