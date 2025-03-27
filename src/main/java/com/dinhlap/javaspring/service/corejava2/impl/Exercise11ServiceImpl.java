package com.dinhlap.javaspring.service.corejava2.impl;

import com.dinhlap.javaspring.service.corejava2.Exercise11Service;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Exercise11ServiceImpl implements Exercise11Service {
    private final Map<String, String> dictionary = new HashMap<>();

    @Override
    public String searchWord(String word) {
        return dictionary.get(word);
    }

    @Override
    public void addWord(String word, String meaning) {
        dictionary.put(word, meaning);
    }
}
