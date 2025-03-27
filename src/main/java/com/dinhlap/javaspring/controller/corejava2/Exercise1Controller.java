package com.dinhlap.javaspring.controller.corejava2;

import com.dinhlap.javaspring.service.corejava2.Exercise1Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/core-java-2/exercise-1")
@Tag(name = "Core Java 2 - Exercise 1", description = "APIs for Core Java 2 - Exercise 1")
public class Exercise1Controller {
    @Autowired
    private Exercise1Service exercise1Service;

    @Operation(summary = "Add element to list", description = "Input a numbers, returns an ArrayList of numbers has been added element.")
    @GetMapping("/add")
    public ResponseEntity<?> addElementToList(@RequestParam int element) {
        return ResponseEntity.ok(exercise1Service.addElementToList(element));
    }

    @Operation(summary = "Display list", description = "Display ArrayList of numbers.")
    @GetMapping("/display")
    public ResponseEntity<?> displayList() {
        return ResponseEntity.ok(exercise1Service.displayElementsInList());
    }

    @Operation(summary = "Remove element from list", description = "Input a numbers, returns an ArrayList of numbers has been removed element.")
    @GetMapping("/remove")
    public ResponseEntity<?> removeElementFromList(@RequestParam int element) {
        return ResponseEntity.ok(exercise1Service.removeElementFromList(element));
    }

    @Operation(summary = "Sum of elements in list", description = "Returns the sum of elements in list.")
    @GetMapping("/sum")
    public ResponseEntity<?> sumOfElementsInList() {
        return ResponseEntity.ok(exercise1Service.sumOfElementsInList());
    }

    @Operation(summary = "Max element in list", description = "Returns the max element in list.")
    @GetMapping("/max")
    public ResponseEntity<?> maxElementInList() {
        return ResponseEntity.ok(exercise1Service.maxElementInList());
    }

    @Operation(summary = "Min element in list", description = "Returns the min element in list.")
    @GetMapping("/min")
    public ResponseEntity<?> minElementInList() {
        return ResponseEntity.ok(exercise1Service.minElementInList());
    }

    @Operation(summary = "Check element in list", description = "Input a numbers, returns an ArrayList of numbers has been checked element.")
    @GetMapping("/check")
    public ResponseEntity<?> checkElementInList(@RequestParam int element) {
        if (!exercise1Service.checkElementInList(element)) {
            return ResponseEntity.badRequest().body("Element is not in list.");
        }
        return ResponseEntity.ok("Element is in list.");
    }
}
