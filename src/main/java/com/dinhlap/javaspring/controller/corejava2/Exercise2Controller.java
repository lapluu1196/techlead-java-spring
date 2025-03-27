package com.dinhlap.javaspring.controller.corejava2;

import com.dinhlap.javaspring.service.corejava2.Exercise2Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/core-java-2/exercise-2")
@Tag(name = "Core Java 2 - Exercise 2", description = "APIs for Core Java 2 - Exercise 2")
public class Exercise2Controller {
    @Autowired
    private Exercise2Service exercise2Service;

    @Operation(summary = "Add a country", description = "Input a country, returns the set of countries.")
    @PostMapping("/add-country")
    public ResponseEntity<?> addCountry(String country) {
        return ResponseEntity.ok(exercise2Service.addCountry(country));
    }

    @Operation(summary = "Display countries", description = "Returns the set of countries.")
    @GetMapping("/display-country")
    public ResponseEntity<?> displayCountry() {
        return ResponseEntity.ok(exercise2Service.displayCountry());
    }

    @Operation(summary = "Check if a country exists", description = "Input a country, returns true if the country exists, false otherwise.")
    @GetMapping("/check-country")
    public ResponseEntity<?> checkCountry(String country) {
        if (exercise2Service.checkCountry(country)) {
            return ResponseEntity.ok("The " + country + " exists.");
        } else {
            return ResponseEntity.ok("The " + country + " does not exist.");
        }
    }

    @Operation(summary = "Remove a country", description = "Input a country, returns the set of countries.")
    @PostMapping("/remove-country")
    public ResponseEntity<?> removeCountry(String country) {
        return ResponseEntity.ok(exercise2Service.removeCountry(country));
    }

    @Operation(summary = "Count the number of countries", description = "Returns the number of countries.")
    @GetMapping("/count-country")
    public ResponseEntity<?> countCountry() {
        return ResponseEntity.ok(exercise2Service.countCountry());
    }
}
