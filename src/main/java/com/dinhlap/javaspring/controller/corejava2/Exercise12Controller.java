package com.dinhlap.javaspring.controller.corejava2;

import com.dinhlap.javaspring.service.corejava2.Exercise12Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/core-java-2/exercise-12")
@Tag(name = "Core Java 2 - Exercise 12", description = "APIs for Core Java 2 - Exercise 12")
public class Exercise12Controller {
    @Autowired
    private Exercise12Service exercise12Service;

    @Operation(summary = "Sort by name", description = "Input choice, returns the sorted product list by: 1 - name, 2 - price, 3 - date, 4 - price and date.")
    @GetMapping("/sort-product")
    public ResponseEntity<?> sortProduct(@RequestParam int option) {
        return ResponseEntity.ok(exercise12Service.sortProduct(option));
    }
}
