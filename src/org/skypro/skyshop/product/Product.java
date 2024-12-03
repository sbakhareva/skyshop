package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public abstract class Product implements Searchable {
    private String productName;

    public Product(String productName) {
        if (productName.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым!");
        } else this.productName = productName;
    }

    public void setProductName(String productName) {
        if (productName.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым!");
        } else this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }
    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return productName;
    }

    @Override
    public String getObjName() {
        return productName;
    }
    @Override
    public String getType() {
        return "PRODUCT";
    }
}
