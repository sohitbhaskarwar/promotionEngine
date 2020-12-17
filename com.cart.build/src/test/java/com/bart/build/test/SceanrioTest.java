package com.bart.build.test;

import com.cart.build.models.*;
import com.cart.build.service.CartManager;
import com.cart.build.service.ProductManager;
import com.cart.build.service.PromotionManager;
import com.cart.build.service.PromotionType;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertThat;

public class SceanrioTest {


    public void mockProductData() {
        ProductManager productManager = new ProductManager();

        assertThat(productManager.addProduct(new Product(1, "A", 5)), Is.is(true));
        assertThat(productManager.addProduct(new Product(2, "B", 30)), Is.is(true));
        assertThat(productManager.addProduct(new Product(3, "C", 20)), Is.is(true));
        assertThat(productManager.addProduct(new Product(4, "D", 15)), Is.is(true));
    }

    public void mockPromotionData() {
        ArrayList<ProductDetails> productDetailsList = new ArrayList<>();
        productDetailsList.add(new ProductDetails(3, new Product(1, "A", 50)));

        PromotionManager promotionManager = new PromotionManager();

        assertThat(promotionManager.addNewPromotion(new Promotion(1, productDetailsList, PromotionType.AMOUNT_WISE,
                new PromotionOffered(20))), Is.is(true));
        productDetailsList = new ArrayList<>();

        productDetailsList.add(new ProductDetails(2, new Product(2, "B", 30)));
        assertThat(promotionManager.addNewPromotion(new Promotion(2, productDetailsList,
                PromotionType.AMOUNT_WISE,
                new PromotionOffered(15))), Is.is(true));
        productDetailsList = new ArrayList<>();

        productDetailsList.add(new ProductDetails(1, new Product(3, "C", 20)));
        productDetailsList.add(new ProductDetails(1, new Product(4, "D", 15)));


        assertThat(promotionManager.addNewPromotion(new Promotion(3, productDetailsList,
                PromotionType.AMOUNT_WISE, new PromotionOffered(5))), Is.is(true));


    }

    @Test
    public void scenarioTest() {
        mockPromotionData();
        Cart cart = mockCartData();
        CartManager cartManager = new CartManager();
        cartManager.promoAppliedOnCart(cart);

        cart.setTotalAmount(cartManager.calculateTotalAmount(cart));
        cart.setTotalDiscount(cartManager.calculateDiscountAmount(cart));
        cart.setFinalAmount(cartManager.getFinalAmount(cart));

        assertThat(cart.getFinalAmount(),Is.is((long) 100));
    }

    private Cart mockCartData() {
        Cart cart = new Cart(1, mockProductDetailsMap(), null, 0, 0, 0);
        CartManager cartManager = new CartManager();
        assertThat(cartManager.addNewCart(cart), Is.is(true));

        return cart;
    }

    public HashMap<Integer, ProductDetails> mockProductDetailsMap() {
        HashMap<Integer, ProductDetails> map = new HashMap<>();

        map.put(1, new ProductDetails(1, (new Product(1, "A", 50))));
        map.put(2, new ProductDetails(1, (new Product(2, "B", 30))));
        map.put(3, new ProductDetails(1, (new Product(3, "C", 20))));

        return map;
    }
}
