package com.dinhlap.javaspring.service.corejava2;

import java.util.List;
import java.util.Map;

public interface Exercise4To7Service {
/** Bài tập 4: Sắp xếp ArrayList Hãy tạo một chương trình Java để sắp xếp một ArrayList
    chứa các số nguyên theo thứ tự tăng dần và giảm dần. Sử dụng các phương thức sắp xếp có sẵn
    trong Collection Framework để làm điều này.
*/
    List<Integer> sortList(List<Integer> list);

    /** Bài tập 5: Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target. You may assume that each input would have exactly one solution,
    and you may not use the same element twice. You can return the answer in any order.
            Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].*/
    int[] twoSum(int[] nums, int target);

    /** Bài tập 6: You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day
    in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.*/
    int maxProfit(int[] prices);

    /**
     * Bài tập 7: Tính toán điểm trung bình của sinh viên Hãy viết một chương trình Java để tính điểm trung bình
     * của các sinh viên trong lớp học. Sử dụng HashMap để lưu trữ tên của sinh viên làm key và danh sách điểm số
     * làm value. Sau đó, tính điểm trung bình cho mỗi sinh viên và hiển thị kết quả.
     */
    Map<String, Double> averageScore(Map<String, List<Double>> scores);
}
