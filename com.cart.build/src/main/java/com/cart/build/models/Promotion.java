package com.cart.build.models;

public class Promotion {
    Integer promotionId;
    ProductDetails productDetails;

    PromotionOffered promotionOffered;

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public PromotionOffered getPromotionOffered() {
        return promotionOffered;
    }

    public void setPromotionOffered(PromotionOffered promotionOffered) {
        this.promotionOffered = promotionOffered;
    }
}
