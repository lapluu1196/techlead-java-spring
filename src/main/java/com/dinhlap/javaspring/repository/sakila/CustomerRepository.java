package com.dinhlap.javaspring.repository.sakila;

import com.dinhlap.javaspring.dto.sakilaDTO.Query15;
import com.dinhlap.javaspring.dto.sakilaDTO.Query21;
import com.dinhlap.javaspring.dto.sakilaDTO.Query22;
import com.dinhlap.javaspring.dto.sakilaDTO.Query25;
import com.dinhlap.javaspring.dto.sakilaDTO.Query29;
import com.dinhlap.javaspring.dto.sakilaDTO.Query33;
import com.dinhlap.javaspring.dto.sakilaDTO.Query34;
import com.dinhlap.javaspring.dto.sakilaDTO.Query37;
import com.dinhlap.javaspring.dto.sakilaDTO.Query39;
import com.dinhlap.javaspring.entity.sakila.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT new com.dinhlap.javaspring.dto.sakilaDTO.Query15(c.firstName, c.lastName, a.address, a.address2, a.district, a.city.cityId, a.postalCode, a.phone) " +
            "FROM Customer c " +
            "JOIN c.address a " +
            "JOIN Rental r ON c.customerId = r.customer.customerId " +
            "WHERE r.rentalDate BETWEEN :startDate AND :endDate")
    List<Query15> query15(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query(value = "SELECT new com.dinhlap.javaspring.dto.sakilaDTO.Query21(c.firstName, c.lastName, SUM(p.amount)) " +
            "FROM Customer c " +
            "JOIN Payment p ON c.customerId = p.customer.customerId " +
            "GROUP BY c.customerId, c.firstName, c.lastName " +
            "ORDER BY SUM(p.amount) DESC")
    List<Query21> query21();

    @Query(value = "SELECT c.first_name, c.last_name, a.address, a.phone " +
            "FROM customer c " +
            "JOIN address a ON c.address_id = a.address_id " +
            "JOIN rental r ON c.customer_id = r.customer_id " +
            "JOIN inventory i ON r.inventory_id = i.inventory_id " +
            "JOIN film f ON i.film_id = f.film_id " +
            "JOIN film_category fc ON f.film_id = fc.film_id " +
            "JOIN category cat ON fc.category_id = cat.category_id " +
            "GROUP BY c.customer_id, c.first_name, c.last_name, a.address, a.phone " +
            "HAVING COUNT(DISTINCT cat.category_id) = (SELECT COUNT(*) FROM category)", nativeQuery = true)
    List<Query22> query22();

    @Query(value = "SELECT c.first_name, c.last_name, f.title, COUNT(*) AS rental_count " +
            "FROM customer c " +
            "JOIN rental r ON c.customer_id = r.customer_id " +
            "JOIN inventory i ON r.inventory_id = i.inventory_id " +
            "JOIN film f ON i.film_id = f.film_id " +
            "GROUP BY c.customer_id, f.film_id, c.first_name, c.last_name, f.title " +
            "HAVING COUNT(*) > 1", nativeQuery = true)
    List<Query25> query25();

    @Query(value = "SELECT DISTINCT c.first_name, c.last_name " +
            "FROM customer c " +
            "JOIN rental r ON c.customer_id = r.customer_id " +
            "JOIN inventory i ON r.inventory_id = i.inventory_id " +
            "JOIN film f ON i.film_id = f.film_id " +
            "JOIN film_category fc ON f.film_id = fc.film_id " +
            "JOIN category cat ON fc.category_id = cat.category_id " +
            "WHERE NOT EXISTS ( " +
            "    SELECT 1 " +
            "    FROM rental r2 " +
            "    JOIN inventory i2 ON r2.inventory_id = i2.inventory_id " +
            "    JOIN film f2 ON i2.film_id = f2.film_id " +
            "    JOIN film_category fc2 ON f2.film_id = fc2.film_id " +
            "    WHERE r2.customer_id = c.customer_id " +
            "      AND fc2.category_id = cat.category_id " +
            "      AND r2.rental_date < r.rental_date " +
            ")", nativeQuery = true)
    List<Query29> query29();

    @Query(value = "SELECT c.first_name, c.last_name, COUNT(r.rental_id) AS film_count, SUM(p.amount) AS total_rental_fee " +
            "FROM customer c " +
            "JOIN rental r ON c.customer_id = r.customer_id " +
            "JOIN payment p ON r.rental_id = p.rental_id " +
            "GROUP BY c.customer_id, c.first_name, c.last_name, r.rental_date " +
            "HAVING COUNT(r.rental_id) > 10", nativeQuery = true)
    List<Query33> query33();

    @Query(value = "SELECT c.first_name, c.last_name, COUNT(r.rental_id) AS total_films_rented, SUM(p.amount) AS total_rental_fee " +
            "FROM customer c " +
            "JOIN rental r ON c.customer_id = r.customer_id " +
            "JOIN inventory i ON r.inventory_id = i.inventory_id " +
            "JOIN film f ON i.film_id = f.film_id " +
            "JOIN film_category fc ON f.film_id = fc.film_id " +
            "JOIN category cat ON fc.category_id = cat.category_id " +
            "JOIN payment p ON r.rental_id = p.rental_id " +
            "GROUP BY c.customer_id, c.first_name, c.last_name, cat.category_id " +
            "HAVING COUNT(DISTINCT f.film_id) = ( " +
            "    SELECT COUNT(DISTINCT f2.film_id) " +
            "    FROM film f2 " +
            "    JOIN film_category fc2 ON f2.film_id = fc2.film_id " +
            "    WHERE fc2.category_id = cat.category_id " +
            ")", nativeQuery = true)
    List<Query34> query34();

    @Query(value = "SELECT c.first_name, c.last_name, cat.name AS category_name, COUNT(f.film_id) AS films_rented " +
            "FROM customer c " +
            "JOIN rental r ON c.customer_id = r.customer_id " +
            "JOIN inventory i ON r.inventory_id = i.inventory_id " +
            "JOIN film f ON i.film_id = f.film_id " +
            "JOIN film_category fc ON f.film_id = fc.film_id " +
            "JOIN category cat ON fc.category_id = cat.category_id " +
            "GROUP BY c.customer_id, c.first_name, c.last_name, cat.category_id, cat.name " +
            "HAVING COUNT(DISTINCT cat.category_id) = (SELECT COUNT(*) FROM category)", nativeQuery = true)
    List<Query37> query37();

    @Query(value = "SELECT DISTINCT c.first_name, c.last_name " +
            "FROM customer c " +
            "JOIN rental r ON c.customer_id = r.customer_id " +
            "JOIN inventory i ON r.inventory_id = i.inventory_id " +
            "JOIN film f ON i.film_id = f.film_id " +
            "JOIN film_category fc ON f.film_id = fc.film_id " +
            "JOIN category cat ON fc.category_id = cat.category_id " +
            "WHERE NOT EXISTS ( " +
            "    SELECT 1 " +
            "    FROM rental r2 " +
            "    JOIN inventory i2 ON r2.inventory_id = i2.inventory_id " +
            "    JOIN film f2 ON i2.film_id = f2.film_id " +
            "    JOIN film_category fc2 ON f2.film_id = fc2.film_id " +
            "    WHERE r2.customer_id = c.customer_id " +
            "      AND fc2.category_id = cat.category_id " +
            "      AND r2.rental_date < r.rental_date " +
            ") " +
            "AND NOT EXISTS ( " +
            "    SELECT 1 " +
            "    FROM rental r3 " +
            "    JOIN inventory i3 ON r3.inventory_id = i3.inventory_id " +
            "    JOIN film f3 ON i3.film_id = f3.film_id " +
            "    WHERE r3.customer_id = c.customer_id " +
            "      AND f3.length > 180 " +
            ")", nativeQuery = true)
    List<Query39> query39();

    @Modifying
    @Transactional
    @Query(value = "UPDATE customer c " +
            "SET c.email = CONCAT(c.email, '_horrorlover') " +
            "WHERE c.customer_id IN ( " +
            "    SELECT DISTINCT r.customer_id " +
            "    FROM rental r " +
            "    JOIN inventory i ON r.inventory_id = i.inventory_id " +
            "    JOIN film f ON i.film_id = f.film_id " +
            "    JOIN film_category fc ON f.film_id = fc.film_id " +
            "    JOIN category cat ON fc.category_id = cat.category_id " +
            "    WHERE cat.name = 'Horror' " +
            "      AND r.rental_date BETWEEN '2022-10-01' AND '2022-10-31' " +
            ")", nativeQuery = true)
    int query44();

    @Modifying
    @Transactional
    @Query(value = "UPDATE customer c1 " +
            "JOIN address a1 ON c1.address_id = a1.address_id " +
            "SET a1.address = CONCAT(a1.address, '_samecity') " +
            "WHERE EXISTS ( " +
            "    SELECT 1 " +
            "    FROM customer c2 " +
            "    JOIN address a2 ON c2.address_id = a2.address_id " +
            "    WHERE c1.customer_id != c2.customer_id " +
            "      AND c1.last_name = c2.last_name " +
            "      AND a1.city_id = a2.city_id " +
            ")", nativeQuery = true)
    int query48();
}
