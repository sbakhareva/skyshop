package org.skypro.skyshop.product;

public class Product {
    private final String productName;
    private final int price;

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    @Override
    public String toString() {
        return productName + ": " + price;
    }
    public String getProductName() {
        return this.productName;
    }
    public int getPrice() {
        return this.price;
    }
}
