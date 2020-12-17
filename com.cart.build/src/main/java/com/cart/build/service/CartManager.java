package com.cart.build.service;

import com.cart.build.models.Cart;
import com.cart.build.models.Product;
import com.cart.build.models.ProductDetails;
import com.cart.build.models.Promotion;

import java.util.*;

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
                System.out.println("Cart already Present with Id "+cart.getCartId()+" !!!");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
}
