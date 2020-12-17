package com.bart.build.test;

import com.cart.build.models.Product;
import com.cart.build.service.ProductManager;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class ProductTest {

    @Test
    public void AddNewProductTest(){
        Product product = new Product(1,"ABC", 20);
        ProductManager productManager = new ProductManager();

        assertThat(productManager.addProduct(product), Is.is(true));
        assertThat(productManager.addProduct(product), Is.is(false));

    }
}
