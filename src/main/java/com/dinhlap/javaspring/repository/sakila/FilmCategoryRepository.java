package com.dinhlap.javaspring.repository.sakila;

import com.dinhlap.javaspring.dto.sakilaDTO.Query14;
import com.dinhlap.javaspring.entity.sakila.FilmCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmCategoryRepository extends JpaRepository<FilmCategory, Integer> {
    @Query(value = "SELECT new com.dinhlap.javaspring.dto.sakilaDTO.Query14(c.name, AVG(f.rentalDuration)) " +
            "FROM Film f " +
            "JOIN FilmCategory fc ON f.filmId = fc.film.filmId " +
            "JOIN Category c ON fc.category.categoryId = c.categoryId " +
            "GROUP BY c.name")
    List<Query14> query14();
}
