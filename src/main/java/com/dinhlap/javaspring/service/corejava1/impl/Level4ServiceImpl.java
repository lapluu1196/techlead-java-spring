package com.dinhlap.javaspring.service.corejava1.impl;

import com.dinhlap.javaspring.service.corejava1.Level4Service;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Level4ServiceImpl implements Level4Service {
    @Override
    public int minMoves(int[] arr) {
        int moves = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    moves++;
                }
            }
        }
        return moves;
    }

    @Override
    public int countSubsequences(int[] arr, int target) {
        return countSubsequencesHelper(arr, target, 0, 0);
    }

    @Override
    public int longestCommonSubstring(String[] arr) {
        int maxLength = 0;
        String minLengthString = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() < minLengthString.length()) {
                minLengthString = arr[i];
            }
        }

        for (int i = 0; i < minLengthString.length(); i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].contains(minLengthString.substring(i))) {
                    count++;
                }
            }
            if (count == arr.length) {
                maxLength++;
            }
        }

        return maxLength;
    }

    @Override
    public int maxProduct(int[] arr) {
        int max = arr[0] * arr[1] * arr[2];
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int product = arr[i] * arr[j] * arr[k];
                    if (product > max) {
                        max = product;
                    }
                }
            }
        }

        return max;
    }

    @Override
    public String[] sortByLength(String[] arr) {
        Arrays.sort(arr, (a, b) -> {
            int distinctA = (int) a.length();
            int distinctB = (int) b.length();
            if (distinctA == distinctB) {
                return a.compareTo(b);
            }
            return Integer.compare(distinctB, distinctA);
        });

        return arr;
    }

    @Override
    public int longestIncreasingSubsequence(int[] arr) {
        int[] dp = new int[arr.length];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && Math.abs(arr[i] - arr[j]) <= 1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    @Override
    public String[] largestOverlap(String[] arr, int k) {
        return findLargestOverlap(arr, k);
    }

    private int countSubsequencesHelper(int[] arr, int target, int sum, int index) {
        if (sum == target) {
            return 1;
        }
        if (sum > target || index >= arr.length) {
            return 0;
        }

        int include = countSubsequencesHelper(arr, target, sum + arr[index], index + 1);
        int exclude = countSubsequencesHelper(arr, target, sum, index + 1);

        return include + exclude;
    }

    private static String[] findLargestOverlap(String[] strings, int k) {
        String[] res = new String[2];
        int maxOverlap = 0;

        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                int overlap = calculateOverlap(strings[i], strings[j], k);
                if (overlap > maxOverlap) {
                    maxOverlap = overlap;
                    res[0] = strings[i];
                    res[1] = strings[j];
                }
            }
        }
        return res;
    }

    private static int calculateOverlap(String s1, String s2, int k) {
        int maxOverlap = 0;
        int len1 = s1.length();
        int len2 = s2.length();

        for (int length = k; length <= Math.min(len1, len2); length++) {
            for (int start1 = 0; start1 <= len1 - length; start1++) {
                String sub1 = s1.substring(start1, start1 + length);
                for (int start2 = 0; start2 <= len2 - length; start2++) {
                    String sub2 = s2.substring(start2, start2 + length);
                    if (sub1.equals(sub2)) {
                        maxOverlap = Math.max(maxOverlap, length);
                    }
                }
            }
        }
        return maxOverlap;
    }
}
