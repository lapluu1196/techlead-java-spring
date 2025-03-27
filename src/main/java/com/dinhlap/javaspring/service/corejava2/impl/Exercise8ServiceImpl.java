package com.dinhlap.javaspring.service.corejava2.impl;

import com.dinhlap.javaspring.entity.javacore2.Product8;
import com.dinhlap.javaspring.service.corejava2.Exercise8Service;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Exercise8ServiceImpl implements Exercise8Service {
    private final Map<String, Product8> products = new HashMap<>();

    @Override
    public void addProduct(Product8 newProduct) {
        products.put(newProduct.getCode(), newProduct);
    }

    @Override
    public void showProduct() {
        products.forEach((code, product) -> System.out.println(product));
    }

    @Override
    public Product8 searchProduct(String code) {
        Product8 product = products.get(code);
        if (product == null) {
            throw new IllegalArgumentException("Product not found");
        }
        return product;
    }

    @Override
    public void deleteProduct(String code) {
        products.remove(code);
    }

    @Override
    public void updateProduct(Product8 updatedProduct) {
        products.put(updatedProduct.getCode(), updatedProduct);
    }
}
