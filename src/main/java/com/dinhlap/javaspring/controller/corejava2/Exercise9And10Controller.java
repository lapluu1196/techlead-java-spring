package com.dinhlap.javaspring.controller.corejava2;

import com.dinhlap.javaspring.service.corejava2.Exercise9And10Service;
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
@RequestMapping("/api/core-java-2/exercise-9-and-10")
@Tag(name = "Core Java 2 - Exercise 9 and 10", description = "APIs for Core Java 2 - Exercise 9 and 10")
public class Exercise9And10Controller {
    @Autowired
    private Exercise9And10Service exercise9And10Service;

    @Operation(summary = "Count words in a string", description = "Input a string, returns the number of words in a string.")
    @GetMapping("/count-words")
    public ResponseEntity<?> countWords(@RequestParam String s) {
        return ResponseEntity.ok(exercise9And10Service.countWords(s));
    }

    @Operation(summary = "Check score", description = "Input a map of student and score, returns the number of student with each score level.")
    @GetMapping("/check-score")
    public ResponseEntity<?> checkScore(@RequestParam Map<String, List<Double>> scores) {
        return ResponseEntity.ok(exercise9And10Service.checkScore(scores));
    }
}
