package com.dinhlap.javaspring.service.corejava2.impl;

import com.dinhlap.javaspring.service.corejava2.Exercise2Service;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Exercise2ServiceImpl implements Exercise2Service {
    private final Set<String> countries = new HashSet<>();

    @Override
    public Set<String> addCountry(String country) {
        return countries.add(country) ? countries : null;
    }

    @Override
    public void displayCountry() {
        countries.forEach(System.out::println);
    }

    @Override
    public boolean checkCountry(String country) {
        return countries.contains(country);
    }

    @Override
    public Set<String> removeCountry(String country) {
        countries.remove(country);
        return countries;
    }

    @Override
    public int countCountry() {
        return countries.size();
    }
}
