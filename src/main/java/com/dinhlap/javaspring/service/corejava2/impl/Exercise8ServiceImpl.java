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
    public String addProduct(Product8 newProduct) {
        if (products.containsKey(newProduct.getCode())) {
            return "Product already exists";
        }
        products.put(newProduct.getCode(), newProduct);
        return "Product added successfully";
    }

    @Override
    public String showProduct() {
        if (products.isEmpty()) {
            return "No products found";
        }
        StringBuilder sb = new StringBuilder();
        for (Product8 product : products.values()) {
            sb.append(product).append("\n");
        }
        return sb.toString();
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
    public String deleteProduct(String code) {
        products.remove(code);
        if (products.containsKey(code)) {
            return "Delete failed";
        }
        return "Product deleted successfully";
    }

    @Override
    public String updateProduct(Product8 updatedProduct) {
        if (!products.containsKey(updatedProduct.getCode())) {
            return "Product not found";
        }
        products.put(updatedProduct.getCode(), updatedProduct);
        return "Product updated successfully";
    }
}
