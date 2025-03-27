package com.dinhlap.javaspring.service.corejava1;

public interface Level2Service {
/** Write a program that takes a list of numbers as input and returns the second largest number in the list.
    VD: [70, 11, 20, 4, 100] 👉 70*/
    int secondLargest(int[] arr);
    
/** Write a program that takes a list of strings as input and returns the longest word in the list.
    VD: [“apple", “banana", “cherry"] 👉 “cherry"*/
    String longestWord(String[] arr);
    
/** Write a program that takes two strings as input and returns the longest common subsequence of the two strings.
            VD: đầu vào [“abcdef", “abczyzcdef”], Đầu ra: “cdef"*/
    String longestCommonSubsequence(String s1, String s2);
    
/** Write a program that takes a list of numbers as input and returns the sum of the numbers that are divisible by both 3 and 5.*/
    int sumDivisibleBy3And5(int[] arr);
    
/** Write a program that takes a list of integers as input and returns the maximum sum of any contiguous subarray within the list.*/
    int maxSubarraySum(int[] arr);
}
