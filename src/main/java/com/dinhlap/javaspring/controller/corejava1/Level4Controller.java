package com.dinhlap.javaspring.controller.corejava1;

import com.dinhlap.javaspring.service.corejava1.Level4Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/core-java-1/level-4")
@Tag(name = "Core Java 1 - Level 4", description = "APIs for Core Java 1 - Level 4")
public class Level4Controller {
    @Autowired
    private Level4Service level4Service;

    @Operation(summary = "Number of moves", description = "Input an array of numbers, returns the number of moves required to sort the list in ascending order using bubble sort.")
    @GetMapping("/number-of-moves")
    public ResponseEntity<?> numberOfMoves(@RequestParam int[] arr) {
        return ResponseEntity.ok(level4Service.minMoves(arr));
    }

    @Operation(summary = "the number of distinct subsequences", description = "Input an array of numbers, return the number of distinct subsequences of the list that sum up to a target value.")
    @GetMapping("/the-number-of-distinct-subsequences")
    public ResponseEntity<?> numberOfDistinctSubsequences(@RequestParam int[] arr, @RequestParam int target) {
        return ResponseEntity.ok(level4Service.countSubsequences(arr, target));
    }

    @Operation(summary = "the longest substring", description = "Input an array of strings, returns the length of the longest substring that appears in every string in the list.")
    @GetMapping("/the-longest-substring")
    public ResponseEntity<?> longestSubstring(@RequestParam String[] arr) {
        return ResponseEntity.ok(level4Service.longestCommonSubstring(arr));
    }

    @Operation(summary = "The maximum product", description = "Input an array of numbers, returns the maximum product of any three distinct elements in the list.")
    @GetMapping("/the-maximum-product")
    public ResponseEntity<?> maxProduct(@RequestParam int[] arr) {
        return ResponseEntity.ok(level4Service.maxProduct(arr));
    }

    @Operation(summary = "Sort by length", description = "Input an array of strings, returns the sorted by the number of distinct words in each string, with the longest strings appearing first.")
    @GetMapping("/sort-by-length")
    public ResponseEntity<?> sortByLength(@RequestParam String[] arr) {
        return ResponseEntity.ok(level4Service.sortByLength(arr));
    }

    @Operation(summary = "Longest increasing subsequence", description = "Input an array of numbers, returns the length of the longest increasing \n" +
            "    subsequence of the numbers, with the additional constraint that no two adjacent elements in the subsequence\n" +
            "    can differ by more than 1.")
    @GetMapping("/longest-increasing-subsequence")
    public ResponseEntity<?> longestIncreasingSubsequence(@RequestParam int[] arr) {
        return ResponseEntity.ok(level4Service.longestIncreasingSubsequence(arr));
    }

    @Operation(summary = "Largest overlap", description = "Input an array of strings, returns the two strings with the largest overlap\n" +
            "    of substrings, where the substrings must be at lea\tst k characters long (where k is a parameter to the function).")
    @GetMapping("/largest-overlap")
    public ResponseEntity<?> largestOverlap(@RequestParam String[] arr, @RequestParam int k) {
        return ResponseEntity.ok(level4Service.largestOverlap(arr, k));
    }
}
