package com.dinhlap.javaspring.controller.corejava2;

import com.dinhlap.javaspring.entity.javacore2.Product8;
import com.dinhlap.javaspring.service.corejava2.Exercise8Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/core-java-2/exercise-8")
@Tag(name = "Core Java 2 - Exercise 8", description = "APIs for Core Java 2 - Exercise 8")
public class Exercise8Controller {
    @Autowired
    private Exercise8Service exercise8Service;

    @Operation(summary = "Add a product", description = "Input a product (code, name, price, quantity), returns status of the product added.")
    @PostMapping("/add-product")
    public ResponseEntity<?> addProduct(@RequestParam String code, @RequestParam String name, @RequestParam double price, @RequestParam int quantity) {
        Product8 product = new Product8(code, name, price, quantity);
        return ResponseEntity.ok(exercise8Service.addProduct(product));
    }

    @Operation(summary = "Show all products", description = "Returns all products.")
    @GetMapping("/show-product")
    public ResponseEntity<?> showProduct() {
        return ResponseEntity.ok(exercise8Service.showProduct());
    }

    @Operation(summary = "Search a product", description = "Input a product code, returns the product searched.")
    @GetMapping("/search-product")
    public ResponseEntity<?> searchProduct(@RequestParam String code) {
        return ResponseEntity.ok(exercise8Service.searchProduct(code));
    }

    @Operation(summary = "Delete a product", description = "Input a product code, returns status of the product deleted.")
    @PostMapping("/delete-product")
    public ResponseEntity<?> deleteProduct(@RequestParam String code) {
        return ResponseEntity.ok(exercise8Service.deleteProduct(code));
    }

    @Operation(summary = "Update a product", description = "Input a product (code, name, price, quantity), returns status of the product updated.")
    @PostMapping("/update-product")
    public ResponseEntity<?> updateProduct(@RequestParam String code, @RequestParam String name, @RequestParam double price, @RequestParam int quantity) {
        Product8 product = new Product8(code, name, price, quantity);
        return ResponseEntity.ok(exercise8Service.updateProduct(product));
    }
}
