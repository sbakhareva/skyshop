package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private final int fixPrice = 75;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public int getPrice() {
        return this.fixPrice;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public String toString() {
        return getProductName() + ", фиксированная цена: " + getPrice();
    }
}
