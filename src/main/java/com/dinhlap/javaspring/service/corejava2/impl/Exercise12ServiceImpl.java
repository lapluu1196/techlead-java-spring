package com.dinhlap.javaspring.service.corejava2.impl;

import com.dinhlap.javaspring.entity.javacore2.Product12;
import com.dinhlap.javaspring.service.corejava2.Exercise12Service;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Service
public class Exercise12ServiceImpl implements Exercise12Service {
    private final Set<Product12> productList = new HashSet<>();

    public Exercise12ServiceImpl() {
        productList.add(new Product12("Laptop", "L01", 5000000,LocalDate.of(2022, 1, 1)));
        productList.add(new Product12("Laptop", "L02", 6000000, LocalDate.of(2022, 1, 2)));
        productList.add(new Product12("Laptop", "L03", 7000000, LocalDate.of(2022, 1, 3)));
        productList.add(new Product12("Laptop", "L04", 8000000, LocalDate.of(2022, 1, 4)));
        productList.add(new Product12("Laptop", "L05", 9000000, LocalDate.of(2022, 1, 5)));
        productList.add(new Product12("Laptop", "L06", 10000000, LocalDate.of(2022, 1, 6)));
        productList.add(new Product12("Macbook", "L07", 11500000, LocalDate.of(2022, 1, 7)));
        productList.add(new Product12("Macbook", "L08", 7500000, LocalDate.of(2022, 1, 8)));
        productList.add(new Product12("PC", "L09", 13500000, LocalDate.of(2022, 1, 9)));
        productList.add(new Product12("PC", "L10", 9500000, LocalDate.of(2022, 1, 10)));
        productList.add(new Product12("PC", "L11", 10500000, LocalDate.of(2022, 1, 9)));
    }


    @Override
    public Set<Product12> sortProduct(int option) {
        switch (option) {
            case 1:
                sortByName(productList);
                break;
            case 2:
                sortByPrice(productList);
                break;
            case 3:
                sortByDate(productList);
                break;
            case 4:
                sortByPriceAndDate(productList);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
        return productList;
    }


    public void sortByName(Set<Product12> productList) {
        productList.stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()));
    }

    public void sortByPrice(Set<Product12> productList) {
        productList.stream()
                .sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
    }

    public void sortByDate(Set<Product12> productList) {
        productList.stream()
                .sorted((p1, p2) -> p1.getDateOfManufacture().compareTo(p2.getDateOfManufacture()));
    }

    public void sortByPriceAndDate(Set<Product12> productList) {
        productList.stream()
                .sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                .sorted((p1, p2) -> p1.getDateOfManufacture().compareTo(p2.getDateOfManufacture()));
    }
}
