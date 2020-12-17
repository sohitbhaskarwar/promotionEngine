package com.cart.build.models;


import java.util.*;

public class Cart {

    Integer cartId;
    Map<Integer, ProductDetails> productUnitsMap;
    List<Promotion> promotionsAppliesOnCart;
    Integer totalDiscount;
    Integer totalAmount;
    Integer finalAmount;

    public Cart(Integer cartId, Map<Integer, ProductDetails> productUnitsMap, List<Promotion> promotionsAppliesOnCart,
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

    public Map<Integer, ProductDetails> getProductUnitsMap() {
        return productUnitsMap;
    }

    public void setProductUnitsMap(Map<Integer, ProductDetails> productUnitsMap) {
        this.productUnitsMap = productUnitsMap;
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
