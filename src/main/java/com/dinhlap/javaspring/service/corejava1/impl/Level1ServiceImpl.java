package com.dinhlap.javaspring.service.corejava1.impl;

import com.dinhlap.javaspring.service.corejava1.Level1Service;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Level1ServiceImpl implements Level1Service {
    @Override
    public int sum(int a, int b) {
        return (a + b);
    }

    @Override
    public int length(String s) {
        return s.length();
    }

    @Override
    public int square(int a) {
        return (int) Math.pow(a, 2);
    }

    @Override
    public int max(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    @Override
    public String shortest(String[] arr) {
        if (arr.length == 0) {
            return "";
        }
        int index = 0;
        int min = arr[0].length();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() < min) {
                min = arr[i].length();
                index = i;
            }
        }
        return arr[index];
    }

    @Override
    public int[] sort(int[] arr) {
        return Arrays.stream(arr).sorted().toArray();
    }

    @Override
    public String[] sort(String[] arr) {
        return Arrays.stream(arr).sorted().toArray(String[]::new);
    }

    @Override
    public double median(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length % 2 == 0) {
            return  (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2.0;
        } else {
            return arr[arr.length / 2];
        }
    }

    @Override
    public int countWords(String s) {
        String[] strings = s.split(" ");
        return strings.length;
    }

    @Override
    public int countA(String[] arr) {
        int count = 0;
        for (String str : arr) {
            if (str.contains("a")) {
                count++;
            }
        }
        return count;
    }
}
