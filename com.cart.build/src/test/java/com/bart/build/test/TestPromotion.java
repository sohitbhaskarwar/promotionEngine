package com.bart.build.test;

import com.cart.build.service.CartManager;
import com.cart.build.service.ProductManager;
import com.cart.build.service.PromotionManager;
import com.cart.build.service.PromotionType;
import org.hamcrest.core.Is;
import org.junit.Test;
import com.cart.build.models.*;

import java.util.ArrayList;

import static org.junit.Assert.assertThat;


public class TestPromotion {

    public void mockData() {
        ProductManager productManager = new ProductManager();

        assertThat(productManager.addProduct(new Product(1, "ABC", 20)), Is.is(true));
        assertThat(productManager.addProduct(new Product(2, "XYZ", 20)), Is.is(true));
        assertThat(productManager.addProduct(new Product(3, "LOOP", 20)), Is.is(true));
        assertThat(productManager.addProduct(new Product(4, "OOTD", 20)), Is.is(true));
        assertThat(productManager.addProduct(new Product(5, "WHY", 20)), Is.is(true));

    }

    @Test
    public void TestAddNewPromotion() {

        mockData();
        ArrayList<ProductDetails> productDetailsList = new ArrayList<>();

        ProductDetails productDetails = new ProductDetails(2, new Product(5, "WHY", 20));
        productDetailsList.add(productDetails);
        productDetails = new ProductDetails(2, new Product(4, "OOTD", 20));
        productDetailsList.add(productDetails);

        PromotionOffered promotionOffered = new PromotionOffered(50);

        //Promotion p = new Promotion(1, productDetailsList, PromotionType.PERCENT_WISE, promotionOffered);
        PromotionManager promotionManager = new PromotionManager();
        assertThat(promotionManager.addNewPromotion(new Promotion(1, productDetailsList, PromotionType.PERCENT_WISE, promotionOffered)),
                Is.is(true));
    }


}
