package com.cart.build.models;

public class PromotionOffered {

   Integer amount;

    public PromotionOffered(Integer amount) {
        this.amount = amount;
    }

    public Integer getDiscountAmount() {
        return amount;
    }

    public void setDiscountAmount(Integer discountAmount) {
        this.amount = discountAmount;
    }
}
