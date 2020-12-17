package com.cart.build.models;

import java.util.HashMap;

public class ProductDetails {
    Integer productUnits;
    Product product;

    public ProductDetails(Integer productUnits, Product product) {
        this.productUnits = productUnits;
        this.product = product;
    }



    public Integer getProductUnits() {
        return productUnits;
    }

    public void setProductUnits(Integer productUnits) {
        this.productUnits = productUnits;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
