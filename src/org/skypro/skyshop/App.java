package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new SimpleProduct("Омлет с ветчиной", 150)); // обычный продукт
        basket.addProduct(new FixPriceProduct("Вафли ореховые")); // продукт с фиксированной ценой
        basket.addProduct(new DiscountedProduct("Торт миндальный", 450, 40)); // уцененный продукт

        System.out.println("Общая стоимость корзины: " + basket.calculateBasketCost() + " рублей");
        basket.printBasket();
        basket.isSpecial();


        basket.isThereProduct("Творожный сырок"); // поиск товара, которого нет в корзине
        basket.isThereProduct("Омлет с ветчиной"); // поиск товара, который есть в корзине

        basket.clearBasket(); // очистка корзины
        basket.printBasket(); // печать пустой корзины
        System.out.println("Общая стоимость корзины: " + basket.calculateBasketCost() + " рублей."); // сумма пустой корзины
        basket.isThereProduct("Молоко цельное"); // поиск товара в пустой корзине

        ProductBasket basket1 = new ProductBasket();

        basket1.addProduct(new SimpleProduct("Омлет с овощами", 150));
        basket1.addProduct(new SimpleProduct("Молоко цельное", 98));
        basket1.addProduct(new SimpleProduct("Вафли ореховые", 75));
        basket1.addProduct(new SimpleProduct("Торт миндальный", 450));
        basket1.addProduct(new SimpleProduct("Торт шоколадный", 250));
        basket1.addProduct(new SimpleProduct("Тирамису", 300)); // добавляю товар в заполненную корзину

        basket1.clearBasket();
    }
}
