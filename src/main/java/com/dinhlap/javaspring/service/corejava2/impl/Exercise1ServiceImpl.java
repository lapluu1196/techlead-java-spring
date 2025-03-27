package com.dinhlap.javaspring.service.corejava2.impl;

import com.dinhlap.javaspring.service.corejava2.Exercise1Service;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Exercise1ServiceImpl implements Exercise1Service {
    private final List<Integer> list = new ArrayList<>();

    @Override
    public List<Integer> addElementToList(int element) {
        list.add(element);
        return list;
    }

    @Override
    public void displayElementsInList() {
        list.forEach(System.out::println);
    }

    @Override
    public int sumOfElementsInList() {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }

    @Override
    public int maxElementInList() {
        if (list.isEmpty()) {
            return 0;
        }
        return list.stream().max(Integer::compare).get();
    }

    @Override
    public int minElementInList() {
        if (list.isEmpty()) {
            return 0;
        }
        return list.stream().min(Integer::compare).get();
    }

    @Override
    public List<Integer> removeElementFromList(int element) {
        list.remove(element);
        return list;
    }

    @Override
    public boolean checkElementInList(int element) {
        return list.contains(element);
    }
}
