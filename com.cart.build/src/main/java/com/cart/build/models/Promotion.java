package com.cart.build.models;

import com.cart.build.service.PromotionType;

import java.util.*;

public class Promotion {
    Integer promotionId;
    List<ProductDetails> productDetails;
    PromotionType promotionType;
    PromotionOffered promotionOffered;

    public Promotion(Integer promotionId, List<ProductDetails> productDetails, PromotionType promotionType,
                     PromotionOffered promotionOffered) {
        this.promotionId = promotionId;
        this.productDetails = productDetails;
        this.promotionType = promotionType;
        this.promotionOffered = promotionOffered;
    }


    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public List<ProductDetails> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetails> productDetails) {
        this.productDetails = productDetails;
    }

    public PromotionType getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(PromotionType promotionType) {
        this.promotionType = promotionType;
    }

    public PromotionOffered getPromotionOffered() {
        return promotionOffered;
    }

    public void setPromotionOffered(PromotionOffered promotionOffered) {
        this.promotionOffered = promotionOffered;
    }
}
