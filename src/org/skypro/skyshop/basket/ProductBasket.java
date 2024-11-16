package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] basket;
    private int counter;

    public ProductBasket() {
        this.basket = new Product[5];
    }

    public void addProduct(String product, int price) {
        Product newProduct = new Product(product, price);
        basket[counter++] = newProduct;
        if (counter > basket.length) {
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
            } else if (counter == 0) {
                System.out.println("Корзина пуста!");
                break;
            }
        }
        System.out.println("Итого: " + sum);
    }

    public boolean isThereProduct(String productName) {
        for (Product product : basket) {
            if (product != null && productName.equalsIgnoreCase(product.getProductName())) {
                System.out.println("Этот товар есть в корзине");
            }
        }
        return true;
    }

    public void clearBasket() {
        System.out.println("Очистка корзины!");
        Arrays.fill(basket, null);
    }
}

