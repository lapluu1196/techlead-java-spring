package com.dinhlap.javaspring.service.corejava2.impl;

import com.dinhlap.javaspring.service.corejava2.Exercise4To7Service;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Exercise4To7ServiceImpl implements Exercise4To7Service {
    @Override
    public List<Integer> sortList(List<Integer> list) {
        return list.stream().sorted().toList();
    }

    @Override
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    @Override
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (minPrice > price) {
                minPrice = price;
            }

            int profit = price - minPrice;
            if (maxProfit < profit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

    @Override
    public Map<String, Double> averageScore(Map<String, List<Double>> scores) {
        Map<String, Double> result = new HashMap<>();

        scores.forEach((key, value) -> {
            int sum = 0;
            for (int i = 0; i < value.size(); i++) {
                sum += value.get(i);
            }
            result.put(key, (double) (sum / value.size()));
        });

        return result;
    }
}
