package com.dinhlap.javaspring.controller.corejava2;

import com.dinhlap.javaspring.service.corejava2.Exercise11Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/core-java-2/exercise-11")
@Tag(name = "Core Java 2 - Exercise 11", description = "APIs for Core Java 2 - Exercise 11")
public class Exercise11Controller {
    @Autowired
    private Exercise11Service exercise11Service;

    @Operation(summary = "Search word", description = "Input a word, returns the meaning of the word.")
    @GetMapping("/search-word")
    public ResponseEntity<?> searchWord(@RequestParam String word) {
        return ResponseEntity.ok(exercise11Service.searchWord(word));
    }

    @Operation(summary = "Add word", description = "Input a word and its meaning, adds the word to the dictionary.")
    @PostMapping("/add-word")
    public ResponseEntity<?> addWord(@RequestParam String word, @RequestParam String meaning) {
        try {
            exercise11Service.addWord(word, meaning);
            return ResponseEntity.ok("Word added successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
