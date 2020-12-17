package com.cart.build.models;


import java.util.*;

public class Cart {

    Integer cartId;
    ArrayList<ProductDetails> productList;
    List<Promotion> promotionsAppliesOnCart;
    Integer totalDiscount;
    Integer totalAmount;
    Integer finalAmount;
}
