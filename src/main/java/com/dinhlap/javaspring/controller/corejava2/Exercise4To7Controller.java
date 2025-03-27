package com.dinhlap.javaspring.controller.corejava2;

import com.dinhlap.javaspring.service.corejava2.Exercise4To7Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/core-java-2/exercise-4-to-7")
@Tag(name = "Core Java 2 - Exercise 4 to 7", description = "APIs for Core Java 2 - Exercise 4 to 7")
public class Exercise4To7Controller {
    @Autowired
    private Exercise4To7Service exercise4To7Service;

    @Operation(summary = "Sort an list of integer", description = "Input an array of integer, returns the sorted array.")
    @GetMapping("/sort-string")
    public ResponseEntity<?> sort(@RequestParam List<Integer> nums) {
        return ResponseEntity.ok(exercise4To7Service.sortList(nums));
    }

    @Operation(summary = "Indices of the two numbers", description = "Input an array of integer and a target, returns the indices of the two numbers.")
    @GetMapping("/two-sum")
    public ResponseEntity<?> twoSum(@RequestParam int[] nums, @RequestParam int target) {
        return ResponseEntity.ok(exercise4To7Service.twoSum(nums, target));
    }

    @Operation(summary = "Max profit", description = "Input an array of prices, returns the max profit.")
    @GetMapping("/max-profit")
    public ResponseEntity<?> maxProfit(@RequestParam int[] prices) {
        return ResponseEntity.ok(exercise4To7Service.maxProfit(prices));
    }

    @Operation(summary = "Count students by score", description = "Input an array of scores, returns the count of students by score.")
    @GetMapping("/count-students-by-score")
    public ResponseEntity<?> countStudentsByScore(@RequestParam Map<String, List<Double>> scores) {
        return ResponseEntity.ok(exercise4To7Service.averageScore(scores));
    }
}
