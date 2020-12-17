package com.bart.build.test;

import com.cart.build.models.*;
import com.cart.build.service.CartManager;
import com.cart.build.service.PromotionManager;
import com.cart.build.service.PromotionType;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertThat;

public class CartTest {


    @Test
    public void addNewCart() {
        Cart cart = new Cart(1, mockProductDetailsMap(), mockPromotionData(), 0, 0, 0);
        CartManager cartManager = new CartManager();
        assertThat(cartManager.addNewCart(cart), Is.is(true));

    }

    public HashMap<Integer, ProductDetails> mockProductDetailsMap(){
        HashMap<Integer, ProductDetails> map = new HashMap<>();

        map.put(1, new ProductDetails(2, (new Product(1, "ABC", 20))));
        map.put(2, new ProductDetails(2, (new Product(2, "XCC", 30))));

        return map;
    }

    @Test
    public void validateTotalAmountForCart() {
        Cart cart = new Cart(1, mockProductDetailsMap(), mockPromotionData(), 0, 0, 0);
        CartManager cartManager = new CartManager();
        assertThat(cartManager.calculateTotalAmount(cart), Is.is((long) 100));
    }

    @Test
    public void validateTotalDiscountForCart() {
        Cart cart = new Cart(1, mockProductDetailsMap(), mockPromotionData(), 0, 0, 0);
        CartManager cartManager = new CartManager();
        assertThat(cartManager.calculateDiscountAmount(cart), Is.is((long) 50));
    }

    @Test
    public void validateFinalAmountForCart() {
        Cart cart = new Cart(1, mockProductDetailsMap(), mockPromotionData(), 77, 577, 0);
        CartManager cartManager = new CartManager();
        assertThat(cartManager.getFinalAmount(cart), Is.is((long) 500));
    }

    private List<Promotion> mockPromotionData() {

        ArrayList<ProductDetails> productDetailsList = new ArrayList<>();

        ProductDetails productDetails = new ProductDetails(2, new Product(5, "WHY", 20));
        productDetailsList.add(productDetails);
        productDetails = new ProductDetails(2, new Product(4, "OOTD", 20));
        productDetailsList.add(productDetails);

        PromotionOffered promotionOffered = new PromotionOffered(50);

        //Promotion p = new Promotion(1, productDetailsList, PromotionType.PERCENT_WISE, promotionOffered);
        PromotionManager promotionManager = new PromotionManager();
        Promotion promotion = new Promotion(1, productDetailsList, PromotionType.AMOUNT_WISE,
                promotionOffered);
        assertThat(promotionManager.addNewPromotion(promotion), Is.is(true));

        List<Promotion> promotionList = new ArrayList<>();
        promotionList.add(promotion);
        return promotionList;
    }
}
