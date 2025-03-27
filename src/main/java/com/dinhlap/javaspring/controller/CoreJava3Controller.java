package com.dinhlap.javaspring.controller;

import com.dinhlap.javaspring.service.corejava3.CoreJava3Service;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/core-java-3")
@Tag(name = "Core Java 3", description = "APIs for Core Java 3")
public class CoreJava3Controller {
    @Autowired
    private CoreJava3Service coreJava3Service;

    @GetMapping("/postfix-calculation")
    public ResponseEntity<?> postfixCalculation(@RequestParam String expression) {
        return ResponseEntity.ok(coreJava3Service.infixToPostfixAndCalc(expression));
    }
}
