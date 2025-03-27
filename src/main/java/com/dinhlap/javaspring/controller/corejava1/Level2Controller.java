package com.dinhlap.javaspring.controller.corejava1;

import com.dinhlap.javaspring.service.corejava1.Level2Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/core-java-1/level-2")
@Tag(name = "Core Java 1 - Level 2", description = "APIs for Core Java 1 - Level 2")
public class Level2Controller {
    @Autowired
    private Level2Service level2Service;

    @Operation(summary = "Find second largest number", description = "Input an array of numbers, returns the second largest number.")
    @GetMapping("/the-second-largest-number")
    public ResponseEntity<?> secondLargest(@RequestParam int[] arr) {
        return ResponseEntity.ok(level2Service.secondLargest(arr));
    }

    @Operation(summary = "Find longest word", description = "Input an array of strings, returns the longest word.")
    @GetMapping("/the-longest-word")
    public ResponseEntity<?> longestWord(@RequestParam String[] arr) {
        return ResponseEntity.ok(level2Service.longestWord(arr));
    }

    @Operation(summary = "Find longest common subsequence", description = "Input two strings, returns the longest common subsequence.")
    @GetMapping("/the-longest-common-subsequence")
    public ResponseEntity<?> longestCommonSubsequence(@RequestParam String s1, @RequestParam String s2) {
        return ResponseEntity.ok(level2Service.longestCommonSubsequence(s1, s2));
    }

    @Operation(summary = "Sum of numbers divisible by 3 and 5", description = "Input an array of numbers, returns the sum of the numbers that are divisible by both 3 and 5.")
    @GetMapping("/sum-of-numbers-divisible-by-3-and-5")
    public ResponseEntity<?> sumDivisibleBy3And5(@RequestParam int[] arr) {
        return ResponseEntity.ok(level2Service.sumDivisibleBy3And5(arr));
    }

    @Operation(summary = "Max subarray sum", description = "Input an array of integers, returns the maximum sum of any contiguous subarray within the list.")
    @GetMapping("/max-subarray-sum")
    public ResponseEntity<?> maxSubarraySum(@RequestParam int[] arr) {
        return ResponseEntity.ok(level2Service.maxSubarraySum(arr));
    }
}
