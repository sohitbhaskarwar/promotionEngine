package com.cart.build.models;

public class Product {
    Integer productId;
    String productName;
    Integer prodcutPrice;

    public Product(int id, String name, int price){
        this.productId = id;
        this.productName = name;
        this.prodcutPrice = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProdcutPrice() {
        return prodcutPrice;
    }

    public void setProdcutPrice(Integer prodcutPrice) {
        this.prodcutPrice = prodcutPrice;
    }
}
