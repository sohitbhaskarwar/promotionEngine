package com.cart.build.service;

import com.cart.build.models.Product;

import java.util.HashMap;

public class ProductManager {
    public static HashMap<Integer, Product> productMap = new HashMap<>();

    public boolean addProduct(Product product){
        try{
            if(product == null)
                    throw  new Exception("Enter Valid Product Details !!!!");
            if(!productMap.containsKey(product.getProductId())){
                productMap.put(product.getProductId(), product);
                return true;
            }
            else{
                System.out.println("Product already Present wiht Id!!!!");
                return false;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return true;
        }
    }
}
