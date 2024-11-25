package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    int basePrice;
    int discount;

    public DiscountedProduct(String productName, int price, int discount) {
        super(productName);
        this.basePrice = price;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return (int) (basePrice - (basePrice * (this.discount / 100f)));
    }

    public void setPrice(int basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getPrice() + ", скидка " + discount + "%.";
    }
}
