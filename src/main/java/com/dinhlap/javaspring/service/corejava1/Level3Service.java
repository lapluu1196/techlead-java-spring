package com.dinhlap.javaspring.service.corejava1;

public interface Level3Service {
/** Write a program that takes a list of numbers as input and returns the second smallest number in the list.
    Ngược lại bài 2.1*/
    int secondSmallest(int[] arr);

/** Write a program that takes a list of integers as input and returns the maximum difference between any two elements in the list.
            VD: [1, 2, 91, 9, 100] 👉 99 ( ket qua cua 100 - 1 )*/
    int maxDiff(int[] arr);

/** Write a program that takes a list of integers as input and returns the longest increasing subsequence of the numbers. ( Tìm độ dài của chuỗi con tịnh tiến dài nhất )
    VD:
            [3, 10, 2, 1, 20] 👉 3 ( The 	longest increasing subsequence is [3, 10, 20] )

            [50, 3, 10, 7, 40, 80 ] 👉 4 ( the longest increasing subsequence is {3, 7, 40, 80} )*/
    int longestIncreasingSubsequence(int[] arr);

/** Write a program that takes a list of strings as input and returns the two strings with the largest overlap of characters.
    Tìm 2 chuỗi có nhiều số ký tự trùng nhau nhất
    VD:["hello", "world", "foobar", "barfoo", "he", "llo"] 👉 ["foobar", "barfoo"]

            ["hello", "world", "foobar", "barfoo", "he", "llo", “foobars”, “abc”, “cba"] => [“barfoo”, “foobar”] 6/6 overlap.*/
    String[] largestOverlap(String[] arr);

/** Write a program that takes a list of numbers as input and returns the smallest positive integer that cannot be represented as the sum of any subset of the list.
    Ví dụ: [1, 2, 3, 7, 8, 20] => 42
    Giải thích
    Chạy vòng lặp từ 1 đến số dương vô cùng:
    Số 1 có trong mảng => loại
    Tương tự với 2 vàng lặp từ 1 đến số dương vô cùng:
    Số 1 có trong mảng => loại
    Tương tự với 2 3
    Số 4 không có trong mảng nó là tổng của 1 và 3 👉 loại 4
    Tương tự đến 42 thì không có tập hợp số nào trong mảng là 42=> 42 là kết quả*/
    int smallestMissing(int[] arr);

/** Write a program that takes two lists of integers as input and returns the median of the combined list.
    Mở rộng của bài 1.8 nhưng với đầu vào là 2 mảng thay vì 1*/
    double median(int[] arr1, int[] arr2);

/**
 * Write a program that takes a string as input and returns the length of the longest palindrome that can be formed by rearranging the characters in the string.
 * Giải thích : palindrome	: Chuỗi ký tự mà đọc xuôi hay ngược đều giống nhau, vd: aba, uwu
 * VD: “A man a plan a canal Panama” 👉 21 (amanaplanacanalpanama)
 */
    int longestPalindrome(String s);

/** Write a program that takes a list of strings as input and returns the list sorted by the number of distinct characters in each string, with the shortest strings appearing first.
    VD: ['apple', 'banana', 'orange', 'kiwi', 'strawberry'] 👉 ['kiwi', 'apple', 'orange', 'banana', 'strawberry']*/
    String[] sortByNumberOfDistinctCharacters(String[] arr);
}
