package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    Map<String, List<Product>> basket;

    public ProductBasket() {
        this.basket = new HashMap<>();
    }

    public void addProduct(Product product) {
        String productName = product.getProductName();
        int price = product.getPrice();
        List<Product> products = new ArrayList<>();
        products.add(product);
        basket.put(productName, products);
        System.out.println(productName + ": " + price);
    }

    public int calculateBasketCost() {
        int sum = 0;
        for (List<Product> m : basket.values()) {
            for (int i = 0; i < m.size(); i++) {
                int price = m.get(i).getPrice();
                sum += price;
            }
        }
        return sum;
    }

    public void printBasket() {
        System.out.println("\nТовары в корзине: ");
        for (Map.Entry<String, List<Product>> m : basket.entrySet()) {
            System.out.println(m.getValue());
        }
    }

    public boolean isThereProduct(String productName) {
        if (basket.containsKey(productName)) {
            System.out.println("\nТовар '" + productName + "' есть в корзине.");
            return true;
        } else {
            System.out.println("\nТакого товара нет в корзине!");
        }
        return false;
    }

    public void clearBasket() {
        System.out.println("Очистка корзины!");
        basket.clear();
    }

    public void countSpecials() {
        int counter = 0;
        for (List<Product> products : basket.values()) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).isSpecial()) {
                    counter++;
                }
            }
        }
        System.out.println("\nСпециальных товаров в корзине: " + counter);
    }

    public List<Product> deleteProduct(String name) {
        List<Product> deleted = new ArrayList<>();

        for (String key : basket.keySet()) {
            List<Product> products = basket.get(key);
            List<Product> productsToRemove = new ArrayList<>();
            Iterator<Product> basketIterator = products.iterator();
            while (basketIterator.hasNext()) {
                Product nextProduct = basketIterator.next();
                if (nextProduct.getProductName().toLowerCase().replace(" ", "").contains(name.toLowerCase().replace(" ", ""))) {
                    productsToRemove.add(nextProduct);
                    basketIterator.remove();
                }
            }
            deleted.addAll(productsToRemove);
        }

        if (deleted.isEmpty()) {
            System.out.println("Список удаленных продуктов пуст.");
        } else {
            System.out.println("\nПродукты удалены :");
            System.out.println(deleted);
        }
        return deleted;
    }
}

