package com.dinhlap.javaspring.service.corejava2.impl;

import com.dinhlap.javaspring.service.corejava2.Exercise13To18Service;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Exercise13To18ServiceImpl implements Exercise13To18Service {
    @Override
    public Set<Integer> removeDuplicate(int[] arr) {
        Set<Integer> nums = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num : arr) {
            if (nums.contains(num)) {
                duplicates.add(num);
            } else {
                nums.add(num);
            }
        }

        return duplicates;
    }

    @Override
    public Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        return intersection;
    }

    @Override
    public Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }

    @Override
    public int[] findMaxAndMin(Set<Integer> set) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : set) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        return new int[]{min, max};
    }

    @Override
    public Set<String> removeDuplicate(Set<String> set) {
        return set;
    }

    @Override
    public int countWords(Set<String> set) {
        return set.size();
    }
}
