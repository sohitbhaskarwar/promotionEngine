package com.cart.build.service;

import com.cart.build.models.Product;
import com.cart.build.models.Promotion;

import java.util.HashMap;

public class PromotionManager {

    public static HashMap<Integer, Promotion> promotionMap = new HashMap<>();

    public boolean addPromotion(Promotion promotion){
        try{
            if(promotion == null ){
                throw new Exception("Provide promotion details correctly!!!");
            }
            if(!promotionMap.containsKey(promotion.getPromotionId())){
                promotionMap.put(promotion.getPromotionId(), promotion);
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
