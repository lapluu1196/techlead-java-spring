package com.dinhlap.javaspring.service.corejava1;

public interface Level4Service {
    /** Write a program that takes a list of integers as input and returns the minimum number of moves
    required to sort the list in ascending order using bubble sort.
    Đầu vào 1 dãy số bất kỳ
    Đầu ra là số lần lặp để hoàn thành việc sắp xếp nổi bọt
    Gợi ý: Tìm hiểu về sắp xếp nổi bọt ( bubble sort ). Tìm số lần sắp xếp nổi bọt cần để hoàn thành
    việc sắp xếp với mảng đầu vào
    VD: [3, 1, 4, 2, 6, 5] cần 4 lần sắp xếp để hoàn thành*/
    int minMoves(int[] arr);

    /** Write a program that takes a list of integers as input and returns the number of distinct
    subsequences of the list that sum up to a target value.
    VD:
    Đầu vào [1, 2, 3, 4, 5] và 5 👉 2 ( vì 2 + 3 và 1 + 4 bằng 5 )
    Đầu vào [1, 1, 2, 3, 4] và 5 👉 4 ( vì 4 tổ hợp có tổng bằng 5 )*/
    int countSubsequences(int[] arr, int target);
    
    /** Write a program that takes a list of strings as input and returns the length of the longest
    substring that appears in every string in the list.
            VD:
            ["abcdefg", "abcde", "abcdef", "ab", "abc"] => 2
            ["programming", "programmer", "program"] => 7
            ["hello", "world", "jelly"] => 1
            ["abcd", "ab", "abcd", "ab", "abcd"] => 2*/
    int longestCommonSubstring(String[] arr);
    
    /** Write a program that takes a list of integers as input and returns the maximum product of any 
    three distinct elements in the list.
    Ví dụ: [-10, -5, 0, 1, 2, 3, 4] 👉 200 (tích của -10, -5 và 4)*/
    int maxProduct(int[] arr);
    
    /** Write a program that takes a list of strings as input and returns the list sorted by the
    number of distinct words in each string, with the longest strings appearing first.
    (Khuyến khích dùng forEach với javascript )
    Sắp xếp từ chuỗi dài nhất đến ngắn nhất, trong trường hợp có 2 chuỗi cùng độ dài thì sắp
    xếp theo thứ tự bảng chữ cái
    Ví dụ: ['the quick brown fox', 'the lazy dog jumps over the fence', 'the cat in the hat']
    Kết quả: ['the lazy dog jumps over the fence', 'the quick brown fox', 'the cat in the hat']*/
    String[] sortByLength(String[] arr);
    
    /** Write a program that takes a list of integers as input and returns the length of the longest increasing 
    subsequence of the numbers, with the additional constraint that no two adjacent elements in the subsequence
    can differ by more than 1. ( Khuyến khích dùng reduce )
    VD:
    Đầu vào: [1, 2, 3, 8, 6, 3] kết quả 3
    Đầu vào: [1, 2, 3, 8, 3, 2, 4, 5, 6, 7, 8, 9] kết quả 6*/
    int longestIncreasingSubsequence(int[] arr);
    
    /** Write a program that takes a list of strings as input and returns the two strings with the largest overlap
    of substrings, where the substrings must be at lea	st k characters long (where k is a parameter to the function).
    Giống bài 2.3 nhưng thêm biến k là độ dài các ký tự trùng*/
    String[] largestOverlap(String[] arr, int k);
}
