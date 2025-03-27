package com.dinhlap.javaspring.entity.javacore2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product12 {
    private String name;
    private String code;
    private double price;
    private LocalDate dateOfManufacture;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", dateOfManufacture=" + dateOfManufacture +
                '}';
    }
}