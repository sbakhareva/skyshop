package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.SortedMap;

public class ProductBasket {
    private Product[] basket;
    private int counter;

    public ProductBasket() {
        this.basket = new Product[5];
    }

    public void addProduct(String productName, int price) {
        Product newProduct = new Product(productName, price);
        basket[counter++] = newProduct;
        if (counter >= basket.length) {
            throw new IndexOutOfBoundsException("Невозможно добавить продукт");
        }
    }

    public int calculateBasketCost() {
        int sum = 0;
        for (Product product : basket) {
            if (product != null) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    public void printBasket() {
        int sum = 0;
        for (Product product : basket) {
            if (product != null) {
                System.out.println(product);
                sum += product.getPrice();
            } else if (basket[0] == null) { // не поняла, как проверить, что массив полностью пустой
                System.out.println("Корзина пуста!");
                break;
            }
        }
        System.out.println("Итого: " + sum);
    }

    public boolean isThereProduct(String productName) {
        for (Product product : basket) {
            if (product == null) {
                System.out.println("В корзине нет товаров для сравнения!");
                break;
            } else if (productName.equalsIgnoreCase(product.getProductName())) {
                    System.out.println("Этот товар есть в корзине");
                    break;
                } else {
                    System.out.println("Такого товара нет в корзине");
                    break;
                }
            }
        return true; // тут я не понимаю, как мне правильно вернуть значение boolean, я разобралась только с интами(((
    }

    public void clearBasket() {
        System.out.println("Очистка корзины!");
        Arrays.fill(basket, null);
    }
}

