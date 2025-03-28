package com.dinhlap.javaspring.repository.sakila;

import com.dinhlap.javaspring.dto.sakilaDTO.Query35;
import com.dinhlap.javaspring.entity.sakila.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    @Query(value = "SELECT f.title, c.first_name, c.last_name, COUNT(r.rental_id) AS rental_count " +
            "FROM rental r " +
            "JOIN inventory i ON r.inventory_id = i.inventory_id " +
            "JOIN film f ON i.film_id = f.film_id " +
            "JOIN customer c ON r.customer_id = c.customer_id " +
            "GROUP BY f.title, c.first_name, c.last_name, DATE(r.rental_date) " +
            "HAVING COUNT(r.rental_id) > 1", nativeQuery = true)
    List<Query35> query35();
}
