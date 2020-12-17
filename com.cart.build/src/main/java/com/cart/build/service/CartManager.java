package com.cart.build.service;

import com.cart.build.models.Cart;
import com.cart.build.models.Product;
import com.cart.build.models.ProductDetails;
import com.cart.build.models.Promotion;

import java.util.*;

import static com.cart.build.service.PromotionManager.promotionMap;

public class CartManager {

    public static HashMap<Integer, Cart> cartMap = new HashMap<Integer, Cart>();


    public Map<Integer, ProductDetails> getProdcutDetailsData(Integer cartId) {
        return cartMap.get(cartId).getProductUnitsMap();

    }

    public boolean storeProductDetails(Integer cartId, Product product, Integer productUnits) {

        ProductDetails prodDetails = getProdcutDetailsData(cartId).get(product.getProductId());
        prodDetails.setProductUnits(prodDetails.getProductUnits() + productUnits);

        return true;
    }


    public boolean addNewCart(Cart cart) {
        try {
            if (cart == null)
                throw new Exception("Enter Valid Cart Data !!!!");
            if (!cartMap.containsKey(cart.getCartId())) {
                cartMap.put(cart.getCartId(), cart);
                return true;
            } else {
                System.out.println("Cart already Present with Id " + cart.getCartId() + " !!!");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    public long calculateTotalAmount(Cart cart) {
        long amount = 0;
        for (Map.Entry<Integer, ProductDetails> mapData : cart.getProductUnitsMap().entrySet()) {
            amount += mapData.getValue().getProductUnits() * mapData.getValue().getProduct().getProdcutPrice();
        }
        return amount;
    }

    public long calculateDiscountAmount(Cart cart) {
        long discountAmount = 0;
        HashMap<Promotion, Integer> promotionUnitMap = cart.getPromotionsAppliesOnCart();
        if(promotionUnitMap == null){
            return 0;
        }
        else {
            for(Map.Entry<Promotion, Integer> mapDetails : promotionUnitMap.entrySet()) {
                discountAmount += mapDetails.getKey().getPromotionOffered().getAmount() * (long) mapDetails.getValue();
            }
            return discountAmount;
        }
    }

    public long getFinalAmount(Cart cart) {
        return cart.getTotalAmount() - cart.getTotalDiscount();
    }

    public boolean promoAppliedOnCart(Cart cart) {
        try {
            HashMap<Promotion, Integer> promotionUnitMap = calculatePromoForCart(cart);
            if(promotionUnitMap == null){
                throw new Exception("No promo Can Be Applied On Cart!!!");
            }
            else {
                cart.setPromotionsAppliesOnCart(promotionUnitMap);
                return true;
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    private HashMap<Promotion, Integer> calculatePromoForCart(Cart cart) {
        HashMap<Integer, ProductDetails > productDetailsMap = cart.getProductUnitsMap();
        HashMap<Promotion, Integer> promotionUnitMap = new HashMap<>();
        Promotion promo = null;

        for (Map.Entry<Integer, Promotion> promoMap : promotionMap.entrySet()) {
            List<ProductDetails> productDetails = promoMap.getValue().getProductDetails();
            Integer unit = getPromoApplied(productDetails,
                    productDetailsMap);
            if(unit > 0) {
                promotionUnitMap.put(promoMap.getValue(), unit);
                promo = promoMap.getValue();
            }
        }

        return promotionUnitMap;
    }

    public Integer getPromoApplied(List<ProductDetails> promoProductDetails,
                                   HashMap<Integer, ProductDetails> productsInCart) {

        Integer result = null, count;
        for(ProductDetails ppd : promoProductDetails) {
            count = 0;
            Integer productId = ppd.getProduct().getProductId();
            if(productsInCart.containsKey(productId)){
                Integer productUnitsInCart  = productsInCart.get(productId).getProductUnits();
                if(productUnitsInCart >= ppd.getProductUnits()){
                    count +=  productUnitsInCart/ ppd.getProductUnits();

                    if(result == null){
                        result = count;
                    }
                    else{
                        result = Math.min(result, count);
                    }
                }
            }

            if(result == null || count == 0){
                return 0;
            }
        }
        return result;
    }
}
