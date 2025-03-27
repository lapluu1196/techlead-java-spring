package com.dinhlap.javaspring.service.corejava2.impl;

import com.dinhlap.javaspring.service.corejava2.Exercise3Service;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Exercise3ServiceImpl implements Exercise3Service {
    private final Map<String, Integer> persons = new HashMap<>();

    @Override
    public Map<String, Integer> addPerson(String name, int age) {
        persons.put(name, age);
        return persons;
    }

    @Override
    public void displayPerson() {
        persons.forEach((name, age) -> System.out.println(name + " - " + age));
    }

    @Override
    public int findAge(String name) {
        return persons.get(name);
    }

    @Override
    public Map<String, Integer> removePerson(String name) {
        persons.remove(name);
        return persons;
    }

    @Override
    public boolean checkPerson(String name) {
        return persons.containsKey(name);
    }
}
