package com.dinhlap.javaspring.entity.javacore2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product8 {
    private String code;
    private String name;
    private double price;
    private int quantity;

    @Override
    public String toString() {
        return "Product8{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
