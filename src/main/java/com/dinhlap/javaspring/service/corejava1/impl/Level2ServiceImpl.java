package com.dinhlap.javaspring.service.corejava1.impl;

import com.dinhlap.javaspring.service.corejava1.Level2Service;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Level2ServiceImpl implements Level2Service {
    @Override
    public int secondLargest(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }
        return Arrays.stream(arr).sorted().toArray()[arr.length - 2];
    }

    @Override
    public String longestWord(String[] arr) {
        if (arr.length == 0) {
            return "";
        }
        int max = arr[0].length();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() > max) {
                max = arr[i].length();
            }
        }
        return arr[max];
    }

    @Override
    public String longestCommonSubsequence(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) {
            return "";
        }

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.reverse().toString();
    }

    @Override
    public int sumDivisibleBy3And5(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int num : arr) {
            if (num % 3 == 0 && num % 5 == 0) {
                sum += num;
            }
        }
        return sum;
    }

    @Override
    public int maxSubarraySum(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int maxSum = arr[0];
        int currentSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
