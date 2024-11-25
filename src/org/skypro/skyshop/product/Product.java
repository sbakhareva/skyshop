package org.skypro.skyshop.product;

public abstract class Product implements Searchable {
    private String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }
    public abstract int getPrice();

    public abstract boolean isSpecial();

    public String getSearchTerm() {
        return getProductName();
    }

    public String getType() {
        return "PRODUCT";
    }
}

interface Searchable {
    default String getSearchTerm() {
        return this.getSearchTerm();
    }

    default String getType(){
        return this.getType();
    }

    default String getObjName() {
        return this.getObjName();
    }

    default String getStringRepresentation() {
        return  "Объект " + getObjName() + " типа " + getType();
    }
}
