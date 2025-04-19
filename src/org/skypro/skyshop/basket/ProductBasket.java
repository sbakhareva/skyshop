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
        int sum = basket.values().stream().flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
        System.out.println("Общая сумма корзины: " + sum);
        return sum;
    }

    public void printBasket() {
        basket.values().stream().flatMap(Collection::stream)
                .forEach(System.out::println);
    }

    public boolean isThereProduct(String productName) {
        if (basket.isEmpty()) {
            System.out.println("Корзина пуста!");
        } else if (basket.containsKey(productName)) {
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
        int specials = Math.toIntExact(basket.values().stream().flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count());
        System.out.println("\nСпециальных товаров в корзине: " + specials);
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
            System.out.println("\nПродукты удалены: ");
            System.out.println(deleted);
        }
        return deleted;
    }
}

