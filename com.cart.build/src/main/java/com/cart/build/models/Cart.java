package com.cart.build.models;


import java.util.*;

public class Cart {

    Integer cartId;
    ArrayList<ProductDetails> productList;
    List<Promotion> promotionsAppliesOnCart;
    Integer totalDiscount;
    Integer totalAmount;
    Integer finalAmount;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public ArrayList<ProductDetails> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<ProductDetails> productList) {
        this.productList = productList;
    }

    public List<Promotion> getPromotionsAppliesOnCart() {
        return promotionsAppliesOnCart;
    }

    public void setPromotionsAppliesOnCart(List<Promotion> promotionsAppliesOnCart) {
        this.promotionsAppliesOnCart = promotionsAppliesOnCart;
    }

    public Integer getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Integer totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Integer finalAmount) {
        this.finalAmount = finalAmount;
    }
}
