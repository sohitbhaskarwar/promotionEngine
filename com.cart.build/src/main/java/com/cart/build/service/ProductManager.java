package com.cart.build.service;

import com.cart.build.models.Product;

import java.util.HashMap;

public class ProductManager {
    public static HashMap<Integer, Product> productMap = new HashMap<>();

    public boolean addProduct(Product product){
        try{
            if(!productMap.containsKey(product.getProductId())){
                productMap.put(product.getProductId(), product);
                return true;
            }
            else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
}
