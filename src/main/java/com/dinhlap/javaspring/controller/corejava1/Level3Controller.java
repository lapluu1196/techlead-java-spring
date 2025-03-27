package com.dinhlap.javaspring.controller.corejava1;

import com.dinhlap.javaspring.service.corejava1.Level3Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/core-java-1/level-3")
@Tag(name = "Core Java 1 - Level 3", description = "APIs for Core Java 1 - Level 3")
public class Level3Controller {
    @Autowired
    private Level3Service level3Service;

    @Operation(summary = "Find second smallest number", description = "Input an array of numbers, returns the second smallest number.")
    @GetMapping("/the-second-smallest-number")
    public ResponseEntity<?> secondSmallest(@RequestParam int[] arr) {
        return ResponseEntity.ok(level3Service.secondSmallest(arr));
    }

    @Operation(summary = "The maximum difference", description = "Input an array of numbers, returns the maximum difference between any two numbers in the array.")
    @GetMapping("/the-maximum-difference")
    public ResponseEntity<?> maxDiff(@RequestParam int[] arr) {
        return ResponseEntity.ok(level3Service.maxDiff(arr));
    }

    @Operation(summary = "Longest increasing subsequence of the numbers", description = "Input an array of numbers, returns the longest increasing subsequence of the numbers.")
    @GetMapping("/the-longest-increasing-subsequence-of-the-numbers")
    public ResponseEntity<?> longestIncreasingSubsequence(@RequestParam int[] arr) {
        return ResponseEntity.ok(level3Service.longestIncreasingSubsequence(arr));
    }

    @Operation(summary = "The largest overlap of characters", description = "Input a string, returns the largest overlap of characters.")
    @GetMapping("/the-largest-overlap-of-characters")
    public ResponseEntity<?> largestOverlap(@RequestParam String[] arr) {
        return ResponseEntity.ok(level3Service.largestOverlap(arr));
    }

    @Operation(summary = "Smallest num cannot be represented as the sum", description = "Input an array of numbers, returns the smallest positive integer that cannot be represented as the sum of any subset of the list.")
    @GetMapping("/smallest-num-cannot-be-represented-as-the-sum")
    public ResponseEntity<?> findNumbers(@RequestParam int[] arr) {
        return ResponseEntity.ok(level3Service.smallestMissing(arr));
    }

    @Operation(summary = "The median of 2 arrays", description = "Input 2 arrays of numbers, returns the median of 2 arrays.")
    @GetMapping("/the-median-of-2-arrays")
    public ResponseEntity<?> median(@RequestParam int[] arr1, @RequestParam int[] arr2) {
        return ResponseEntity.ok(level3Service.median(arr1, arr2));
    }

    @Operation(summary = "The longest palindrome", description = "Input an string, returns the longest palindrome.")
    @GetMapping("/the-longest-palindrome")
    public ResponseEntity<?> longestPalindrome(@RequestParam String s) {
        return ResponseEntity.ok(level3Service.longestPalindrome(s));
    }

    @Operation(summary = "Sort by distinct characters", description = "Input an array of strings, returns the sorted array by distinct characters")
    @GetMapping("/sort-by-distinct-characters")
    public ResponseEntity<?> sortByDistinctCharacters(@RequestParam String[] arr) {
        return ResponseEntity.ok(level3Service.sortByNumberOfDistinctCharacters(arr));
    }

}
