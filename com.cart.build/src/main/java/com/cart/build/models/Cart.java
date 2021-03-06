package com.cart.build.models;


import java.util.*;

public class Cart {

    Integer cartId;
    HashMap<Integer, ProductDetails> productUnitsMap;
    HashMap<Promotion, Integer> promotionsAppliesOnCart;
    long totalDiscount;
    long totalAmount;
    long finalAmount;

    public Cart(Integer cartId, HashMap<Integer, ProductDetails> productUnitsMap, HashMap<Promotion, Integer> promotionsAppliesOnCart,
                Integer totalDiscount, Integer totalAmount, Integer finalAmount) {
        this.cartId = cartId;
        this.productUnitsMap = productUnitsMap;
        this.promotionsAppliesOnCart = promotionsAppliesOnCart;
        this.totalDiscount = totalDiscount;
        this.totalAmount = totalAmount;
        this.finalAmount = finalAmount;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public HashMap<Integer, ProductDetails> getProductUnitsMap() {
        return productUnitsMap;
    }

    public void setProductUnitsMap(HashMap<Integer, ProductDetails> productUnitsMap) {
        this.productUnitsMap = productUnitsMap;
    }

    public HashMap<Promotion, Integer> getPromotionsAppliesOnCart() {
        return promotionsAppliesOnCart;
    }

    public void setPromotionsAppliesOnCart(HashMap<Promotion, Integer> promotionsAppliesOnCart) {
        this.promotionsAppliesOnCart = promotionsAppliesOnCart;
    }

    public long getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(long totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(long finalAmount) {
        this.finalAmount = finalAmount;
    }
}
