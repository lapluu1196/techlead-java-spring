package com.dinhlap.javaspring.controller.corejava2;

import com.dinhlap.javaspring.service.corejava2.Exercise13To18Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/core-java-2/exercise-13-to-18")
@Tag(name = "Core Java 2 - Exercise 13 to 18", description = "APIs for Core Java 2 - Exercise 13 to 18")
public class Exercise13To18Controller {
    @Autowired
    private Exercise13To18Service exercise13To18Service;

    @Operation(summary = "Remove duplicate elements", description = "Input an array of numbers, returns an set of numbers without duplicate elements.")
    @GetMapping("/remove-duplicate-elements")
    public ResponseEntity<?> removeDuplicateElements(@RequestParam int[] arr) {
        return ResponseEntity.ok(exercise13To18Service.removeDuplicate(arr));
    }

    @Operation(summary = "Intersection of 2 set", description = "Input 2 set of numbers, returns an intersection of 2 set.")
    @GetMapping("/intersection-of-2-set")
    public ResponseEntity<?> intersectionOf2Set(@RequestParam Set<Integer> arr1, @RequestParam Set<Integer> arr2) {
        return ResponseEntity.ok(exercise13To18Service.intersection(arr1, arr2));
    }

    @Operation(summary = "Union of 2 set", description = "Input 2 set of numbers, returns an union of 2 set.")
    @GetMapping("/union-of-2-set")
    public ResponseEntity<?> unionOf2Set(@RequestParam Set<Integer> arr1, @RequestParam Set<Integer> arr2) {
        return ResponseEntity.ok(exercise13To18Service.union(arr1, arr2));
    }

    @Operation(summary = "Find max and min of set", description = "Input a set of numbers, returns max and min of set.")
    @GetMapping("/find-max-and-min")
    public ResponseEntity<?> findMaxAndMin(@RequestParam Set<Integer> arr) {
        return ResponseEntity.ok(exercise13To18Service.findMaxAndMin(arr));
    }

    @Operation(summary = "Remove duplicate elements", description = "Input an array of strings, returns an set of strings without duplicate elements.")
    @GetMapping("/remove-duplicate-strings")
    public ResponseEntity<?> removeDuplicateStrings(@RequestParam Set<String> arr) {
        return ResponseEntity.ok(exercise13To18Service.removeDuplicate(arr));
    }

    @Operation(summary = "Count words", description = "Input an array of strings, returns a map of words and their count.")
    @GetMapping("/count-words")
    public ResponseEntity<?> countWords(@RequestParam Set<String> arr) {
        return ResponseEntity.ok(exercise13To18Service.countWords(arr));
    }
}
