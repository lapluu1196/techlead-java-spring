package com.dinhlap.javaspring.entity.sakila;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmCategoryId implements Serializable {

    private Integer film;
    private Integer category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmCategoryId that = (FilmCategoryId) o;
        return Objects.equals(film, that.film) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(film, category);
    }
}