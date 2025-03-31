package com.dinhlap.javaspring.repository.sakila;

import com.dinhlap.javaspring.dto.sakilaDTO.Query12;
import com.dinhlap.javaspring.dto.sakilaDTO.Query13;
import com.dinhlap.javaspring.dto.sakilaDTO.Query18;
import com.dinhlap.javaspring.dto.sakilaDTO.Query210;
import com.dinhlap.javaspring.dto.sakilaDTO.Query23;
import com.dinhlap.javaspring.dto.sakilaDTO.Query28;
import com.dinhlap.javaspring.dto.sakilaDTO.Query38;
import com.dinhlap.javaspring.entity.sakila.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Short> {
    @Query("SELECT new com.dinhlap.javaspring.dto.sakilaDTO.Query12(f.title, f.rentalRate, f.replacementCost) FROM Film f")
    List<Query12> queryOneTow();

    @Query(value = """
                   SELECT new com.dinhlap.javaspring.dto.sakilaDTO.Query13(f.title, COUNT(r.rentalId))
                   FROM Film f
                   JOIN f.inventories i
                   JOIN i.rentals r
                   GROUP BY f.title
                   ORDER BY COUNT(r.rentalId) DESC
                   LIMIT 5
                   """)
    List<Query13> findTop5MostRentedFilms();

    @Query("SELECT new com.dinhlap.javaspring.dto.sakilaDTO.Query18(f.title) " +
            "FROM Film f " +
            "WHERE f.rating = 'PG-13' " +
            "AND f.length > 120")
    List<Query18> query18();

    @Query(value = "SELECT f.title " +
            "FROM film f " +
            "JOIN inventory i ON f.film_id = i.film_id " +
            "JOIN rental r ON i.inventory_id = r.inventory_id " +
            "WHERE r.return_date IS NULL", nativeQuery = true)
    List<Query23> query23();

    @Query(value = "SELECT f.title " +
            "FROM film f " +
            "JOIN inventory i ON f.film_id = i.film_id " +
            "JOIN rental r ON i.inventory_id = r.inventory_id " +
            "JOIN customer c ON r.customer_id = c.customer_id " +
            "GROUP BY f.film_id, f.title " +
            "HAVING COUNT(DISTINCT c.customer_id) > 50 " +
            "AND COUNT(*) = COUNT(DISTINCT c.customer_id)",
            nativeQuery = true)
    List<Query28> query28();

    @Query(value = "SELECT f.title " +
            "FROM film f " +
            "JOIN inventory i ON f.film_id = i.film_id " +
            "JOIN rental r ON i.inventory_id = r.inventory_id " +
            "JOIN customer c ON r.customer_id = c.customer_id " +
            "WHERE NOT EXISTS ( " +
            "    SELECT 1 " +
            "    FROM customer c2 " +
            "    JOIN rental r2 ON c2.customer_id = r2.customer_id " +
            "    JOIN inventory i2 ON r2.inventory_id = i2.inventory_id " +
            "    JOIN film f2 ON i2.film_id = f2.film_id " +
            "    JOIN film_category fc2 ON f2.film_id = fc2.film_id " +
            "    JOIN category cat2 ON fc2.category_id = cat2.category_id " +
            "    WHERE cat2.name = 'Action' " +
            "      AND c2.customer_id NOT IN ( " +
            "          SELECT r3.customer_id " +
            "          FROM rental r3 " +
            "          JOIN inventory i3 ON r3.inventory_id = i3.inventory_id " +
            "          WHERE i3.film_id = f.film_id " +
            "      ) " +
            ") " +
            "GROUP BY f.film_id, f.title", nativeQuery = true)
    List<Query210> query210();

    @Query(value = "SELECT f.title " +
            "FROM film f " +
            "JOIN inventory i ON f.film_id = i.film_id " +
            "JOIN rental r ON i.inventory_id = r.inventory_id " +
            "JOIN customer c ON r.customer_id = c.customer_id " +
            "GROUP BY f.title, f.film_id " +
            "HAVING COUNT(r.rental_id) > 100 " +
            "   AND NOT EXISTS ( " +
            "       SELECT 1 " +
            "       FROM rental r2 " +
            "       JOIN inventory i2 ON r2.inventory_id = i2.inventory_id " +
            "       JOIN film f2 ON i2.film_id = f2.film_id " +
            "       WHERE r2.customer_id = c.customer_id " +
            "         AND f2.rating = 'G' " +
            "   )", nativeQuery = true)
    List<Query38> query38();

    @Modifying
    @Transactional
    @Query(value = "UPDATE film f " +
            "SET f.rental_rate = f.rental_rate * 1.10 " +
            "WHERE f.film_id IN ( " +
            "    SELECT i.film_id " +
            "    FROM inventory i " +
            "    JOIN rental r ON i.inventory_id = r.inventory_id " +
            "    GROUP BY i.film_id " +
            "    HAVING COUNT(r.rental_id) > 100 " +
            ")", nativeQuery = true)
    int query41();

    @Modifying
    @Transactional
    @Query(value = "UPDATE film f " +
            "SET f.rental_duration = ROUND(f.rental_duration * 1.05) " +
            "WHERE f.film_id IN ( " +
            "    SELECT i.film_id " +
            "    FROM inventory i " +
            "    JOIN rental r ON i.inventory_id = r.inventory_id " +
            "    GROUP BY i.film_id " +
            "    HAVING COUNT(r.rental_id) > 5 " +
            ")", nativeQuery = true)
    int query42();

    @Modifying
    @Transactional
    @Query(value = "UPDATE film f " +
            "SET f.rental_rate = f.rental_rate * 1.20 " +
            "WHERE f.film_id IN ( " +
            "    SELECT f2.film_id " +
            "    FROM film f2 " +
            "    JOIN film_category fc ON f2.film_id = fc.film_id " +
            "    JOIN category c ON fc.category_id = c.category_id " +
            "    WHERE c.name = 'Action' " +
            "      AND f2.release_year < 2005 " +
            ")", nativeQuery = true)
    int query43();

    @Modifying
    @Transactional
    @Query(value = "UPDATE film f " +
            "SET f.rental_rate = LEAST(f.rental_rate * 1.05, 4.00) " +
            "WHERE f.film_id IN ( " +
            "    SELECT i.film_id " +
            "    FROM inventory i " +
            "    JOIN rental r ON i.inventory_id = r.inventory_id " +
            "    JOIN customer c ON r.customer_id = c.customer_id " +
            "    GROUP BY i.film_id " +
            "    HAVING COUNT(DISTINCT c.customer_id) > 10 " +
            ")", nativeQuery = true)
    int query45();

    @Modifying
    @Transactional
    @Query(value = "UPDATE film " +
            "SET rental_rate = 3.50 " +
            "WHERE rating = 'PG-13' " +
            "  AND length > 120", nativeQuery = true)
    int query46();

    @Modifying
    @Transactional
    @Query(value = "UPDATE film f " +
            "SET f.rental_duration = f.length " +
            "WHERE f.film_id IN ( " +
            "    SELECT f2.film_id " +
            "    FROM film f2 " +
            "    JOIN film_category fc ON f2.film_id = fc.film_id " +
            "    JOIN category c ON fc.category_id = c.category_id " +
            "    WHERE c.name = 'Sci-Fi' " +
            "      AND f2.release_year = 2010 " +
            ")", nativeQuery = true)
    int query47();

    @Modifying
    @Transactional
    @Query(value = "UPDATE film f " +
            "SET f.rental_rate = f.rental_rate * 0.85 " +
            "WHERE f.film_id IN ( " +
            "    SELECT f2.film_id " +
            "    FROM film f2 " +
            "    JOIN film_category fc ON f2.film_id = fc.film_id " +
            "    JOIN category c ON fc.category_id = c.category_id " +
            "    WHERE c.name = 'Comedy' " +
            "      AND f2.release_year >= 2007 " +
            ")", nativeQuery = true)
    int query49();

    @Modifying
    @Transactional
    @Query(value = "UPDATE film " +
            "SET rental_rate = 1.50 " +
            "WHERE rating = 'G' " +
            "  AND length < 60", nativeQuery = true)
    int query410();
}
