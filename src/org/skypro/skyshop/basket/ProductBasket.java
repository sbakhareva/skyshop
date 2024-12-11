package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private final List<Product> basket;
    private int counter;

    public ProductBasket() {
        this.basket = new ArrayList<>();
    }

    public void addProduct(Product product) {
        String productName = product.getProductName();
        int price = product.getPrice();
        basket.add(counter++, product);
        System.out.println(productName + ": " + price);
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
        counter = 0;
        for (Product product : basket) {
            if (product != null) {
                counter++;
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
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        System.out.println("Очистка корзины!");
        basket.clear();
    }

    public void countSpecials() {
        int counter = 0;
        for (Product product : basket) {
            if (product != null && product.isSpecial()) {
                counter++;
            }
        }
        System.out.println("Специальных товаров в корзине: " + counter);
    }

    public List delete(String name) {
        Iterator<Product> iterator = basket.iterator();
        List<Product> deleted = new ArrayList<>();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductName().toLowerCase().replace(" ", "").contains(name.toLowerCase().replace(" ", ""))) {
                deleted.add(product);
                basket.remove(product);
            }
        }
        if (deleted.isEmpty()) {
            System.out.println("Список удаленных продуктов пуст.");
        } else {
            return deleted;
        }
        return null;
    }
}

