package org.skypro.skyshop.product;

public class Product {
    private String productName;
    private int price;

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(int price) {
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
