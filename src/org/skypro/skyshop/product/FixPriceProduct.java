package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private static final int FIXPRICE = 75;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public int getPrice() {
        return FIXPRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public String toString() {
        return getProductName() + ", фиксированная цена: " + getPrice();
    }
}
