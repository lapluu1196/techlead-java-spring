package com.dinhlap.javaspring.service.corejava1.impl;

import com.dinhlap.javaspring.service.corejava1.Level3Service;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class Level3ServiceImpl implements Level3Service {
    @Override
    public int secondSmallest(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }
        return Arrays.stream(arr).sorted().toArray()[1];
    }

    @Override
    public int maxDiff(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }
        return Arrays.stream(arr).sorted().toArray()[arr.length - 1] - Arrays.stream(arr).sorted().toArray()[0];
    }

    @Override
    public int longestIncreasingSubsequence(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    @Override
    public String[] largestOverlap(String[] arr) {
        if (arr.length == 0) {
            return new String[0];
        }
        int maxOverlap = 0;
        String str1 = null;
        String str2 = null;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int overlap = 0;
                for (int k = 0; k < Math.min(arr[i].length(), arr[j].length()); k++) {
                    if (arr[i].charAt(k) == arr[j].charAt(k)) {
                        overlap++;
                    }
                }
                if (overlap > maxOverlap) {
                    maxOverlap = overlap;
                    str1 = arr[i];
                    str2 = arr[j];
                }
            }
        }
        return new String[]{str1, str2};
    }

    @Override
    public int smallestMissing(int[] arr) {
        int res = 1;
        int[] sorted = Arrays.stream(arr).sorted().toArray();

        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] > res) {
                break;
            } else {
                res += sorted[i];
            }
        }
        return res;
    }

    @Override
    public double median(int[] arr1, int[] arr2) {
        int total = arr1.length + arr2.length;
        int[] cList = new int[total];
        for (int i = 0; i < arr1.length; i++) {
            cList[i] = arr1[i];
        }
        for (int i = arr1.length; i < total; i++) {
            cList[i] = arr2[i-arr1.length];
        }

        if (total % 2 == 0) {
            return (cList[total / 2] + cList[total / 2 - 1]) / 2.0;
        } else {
            return cList[total / 2];
        }
    }

    @Override
    public int longestPalindrome(String s) {
        String newString = s.replace(" ", "").toLowerCase();

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : newString.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int res = 0;
        boolean hasOdd = false;

        for (int count : freqMap.values()) {
            if (count % 2 == 0) {
                res += count;
            } else {
                res += count - 1;
                hasOdd = true;
            }
        }

        if (hasOdd) {
            res++;
        }
        return res;
    }

    @Override
    public String[] sortByNumberOfDistinctCharacters(String[] arr) {
        Arrays.sort(arr, (a, b) -> {
            int distinctA = (int) a.chars().distinct().count();
            int distinctB = (int) b.chars().distinct().count();
            if (distinctA == distinctB) {
                return a.compareTo(b);
            }
            return Integer.compare(distinctA, distinctB);
        });
        return arr;
    }
}
