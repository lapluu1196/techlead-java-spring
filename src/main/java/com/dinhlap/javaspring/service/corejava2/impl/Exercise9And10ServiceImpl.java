package com.dinhlap.javaspring.service.corejava2.impl;

import com.dinhlap.javaspring.service.corejava2.Exercise9And10Service;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Exercise9And10ServiceImpl implements Exercise9And10Service {
    @Override
    public Map<String, Integer> countWords(String sentence) {
        Map<String, Integer> result = new HashMap<>();

        String str = sentence.trim().replaceAll("\\s+", " ");
        String[] words = str.split(" ");

        for (int i = 0; i < words.length; i++) {
            result.put(words[i], result.getOrDefault(words[i], 0) + 1);
        }

        return result;
    }

    @Override
    public Map<String, Integer> checkScore(Map<String, List<Double>> scores) {
        int highScore = 0, averageScore = 0, lowScore = 0;

        for (Map.Entry<String, List<Double>> entry : scores.entrySet()) {
            int sum = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                sum += entry.getValue().get(i);
            }
            double avg = (double) sum / entry.getValue().size();
            if (avg >= 8.0) {
                highScore++;
            } else if (avg >= 5.0 && avg < 8.0) {
                averageScore++;
            } else {
                lowScore++;
            }
        }

        Map<String, Integer> result = new HashMap<>();
        result.put(">=8", highScore);
        result.put("<= 5 and < 8", averageScore);
        result.put("< 5", lowScore);

        return result;
    }
}
