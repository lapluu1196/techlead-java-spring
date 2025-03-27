package com.dinhlap.javaspring.controller.corejava2;

import com.dinhlap.javaspring.service.corejava2.Exercise3Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/core-java-2/exercise-3")
@Tag(name = "Core Java 2 - Exercise 3", description = "APIs for Core Java 2 - Exercise 3")
public class Exercise3Controller {
    @Autowired
    private Exercise3Service exercise3Service;

    @Operation(summary = "Add a person", description = "Input a name and an age, returns a map of name-age of a person.")
    @PostMapping("/add-person")
    public ResponseEntity<?> addPerson(String name, int age) {
        return ResponseEntity.ok(exercise3Service.addPerson(name, age));
    }

    @Operation(summary = "Display map of name-age of a person", description = "Returns a map of name-age of a person.")
    @GetMapping("/display-person")
    public ResponseEntity<?> displayPerson() {
        return ResponseEntity.ok(exercise3Service.displayPerson());
    }

    @Operation(summary = "Find age of a person", description = "Input a name, returns the age of a person.")
    @GetMapping("/find-age")
    public ResponseEntity<?> findAge(String name) {
        return ResponseEntity.ok(exercise3Service.findAge(name));
    }

    @Operation(summary = "Remove a person", description = "Input a name, returns a map of name-age of a person.")
    @PostMapping("/remove-person")
    public ResponseEntity<?> removePerson(String name) {
        return ResponseEntity.ok(exercise3Service.removePerson(name));
    }

    @Operation(summary = "Check if a person exists", description = "Input a name, returns a map of name-age of a person.")
    @GetMapping("/check-person")
    public ResponseEntity<?> checkPerson(String name) {
        return ResponseEntity.ok(exercise3Service.checkPerson(name));
    }
}
