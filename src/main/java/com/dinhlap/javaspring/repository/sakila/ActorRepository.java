package com.dinhlap.javaspring.repository.sakila;

import com.dinhlap.javaspring.dto.sakilaDTO.Query11;
import com.dinhlap.javaspring.dto.sakilaDTO.Query17;
import com.dinhlap.javaspring.dto.sakilaDTO.Query24;
import com.dinhlap.javaspring.dto.sakilaDTO.Query26;
import com.dinhlap.javaspring.dto.sakilaDTO.Query27;
import com.dinhlap.javaspring.dto.sakilaDTO.Query31;
import com.dinhlap.javaspring.dto.sakilaDTO.Query310;
import com.dinhlap.javaspring.dto.sakilaDTO.Query32;
import com.dinhlap.javaspring.dto.sakilaDTO.Query36;
import com.dinhlap.javaspring.entity.sakila.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Short> {
    @Query(value = "SELECT new com.dinhlap.javaspring.dto.sakilaDTO.Query11(a.firstName, a.lastName) " +
            "FROM Actor a ")
    List<Query11> query11();

    @Query(value = "SELECT new com.dinhlap.javaspring.dto.sakilaDTO.Query17(a.firstName, a.lastName, COUNT(fa.film.filmId)) " +
            "FROM Actor a " +
            "JOIN FilmActor fa ON a.actorId = fa.actor.actorId " +
            "GROUP BY a.actorId, a.firstName, a.lastName " +
            "HAVING COUNT(fa.film.filmId) > 20")
    List<Query17> query17();

    @Query(value = "SELECT a.first_name, a.last_name " +
            "FROM actor a " +
            "JOIN film_actor fa ON a.actor_id = fa.actor_id " +
            "JOIN film f ON fa.film_id = f.film_id " +
            "JOIN film_category fc ON f.film_id = fc.film_id " +
            "JOIN category c ON fc.category_id = c.category_id " +
            "GROUP BY a.actor_id, a.first_name, a.last_name " +
            "HAVING COUNT(DISTINCT c.category_id) = (SELECT COUNT(*) FROM category)", nativeQuery = true)
    List<Query24> query24();

    @Query(value = "SELECT new com.dinhlap.javaspring.dto.sakilaDTO.Query26(a.lastName, a.firstName, SUM(p.amount)) " +
            "FROM Actor a " +
            "JOIN FilmActor fa ON a.actorId = fa.actor.actorId " +
            "JOIN Film f ON fa.film.filmId = f.filmId " +
            "JOIN Inventory i ON f.filmId = i.film.filmId " +
            "JOIN Rental r ON i.inventoryId = r.inventory.inventoryId " +
            "JOIN Payment p ON r.rentalId = p.rental.rentalId " +
            "GROUP BY a.actorId, a.firstName, a.lastName")
    List<Query26> query26();

    @Query(value = "SELECT a.first_name, a.last_name " +
            "FROM actor a " +
            "JOIN film_actor fa ON a.actor_id = fa.actor_id " +
            "JOIN film f ON fa.film_id = f.film_id " +
            "WHERE f.rating = 'R' " +
            "AND a.actor_id NOT IN (" +
            "    SELECT fa2.actor_id " +
            "    FROM film_actor fa2 " +
            "    JOIN film f2 ON fa2.film_id = f2.film_id " +
            "    WHERE f2.rating = 'G'" +
            ") " +
            "GROUP BY a.actor_id, a.first_name, a.last_name", nativeQuery = true)
    List<Query27> query27();

    @Query(value = "SELECT a.first_name, a.last_name, c.name AS category_name, AVG(f.rental_duration) AS average_rental_duration " +
            "FROM actor a " +
            "JOIN film_actor fa ON a.actor_id = fa.actor_id " +
            "JOIN film f ON fa.film_id = f.film_id " +
            "JOIN film_category fc ON f.film_id = fc.film_id " +
            "JOIN category c ON fc.category_id = c.category_id " +
            "GROUP BY a.actor_id, a.first_name, a.last_name, c.category_id, c.name " +
            "HAVING COUNT(f.film_id) > 0", nativeQuery = true)
    List<Query31> query31();

    @Query(value = "SELECT a.first_name, a.last_name " +
            "FROM actor a " +
            "JOIN film_actor fa ON a.actor_id = fa.actor_id " +
            "JOIN film f ON fa.film_id = f.film_id " +
            "WHERE f.rating = 'R' AND f.length > 120 " +
            "  AND a.actor_id NOT IN ( " +
            "      SELECT a2.actor_id " +
            "      FROM actor a2 " +
            "      JOIN film_actor fa2 ON a2.actor_id = fa2.actor_id " +
            "      JOIN film f2 ON fa2.film_id = f2.film_id " +
            "      WHERE f2.rating = 'G' " +
            "  ) " +
            "GROUP BY a.actor_id, a.first_name, a.last_name", nativeQuery = true)
    List<Query32> query32();

    @Query(value = "SELECT a1.first_name, a1.last_name, COUNT(fa1.film_id) AS film_count " +
            "FROM actor a1 " +
            "JOIN film_actor fa1 ON a1.actor_id = fa1.actor_id " +
            "JOIN film f ON fa1.film_id = f.film_id " +
            "WHERE NOT EXISTS ( " +
            "    SELECT a2.actor_id " +
            "    FROM actor a2 " +
            "    WHERE a2.actor_id != a1.actor_id " +
            "      AND NOT EXISTS ( " +
            "          SELECT 1 " +
            "          FROM film_actor fa2 " +
            "          WHERE fa2.actor_id = a2.actor_id " +
            "            AND fa2.film_id = fa1.film_id " +
            "      ) " +
            ") " +
            "GROUP BY a1.actor_id, a1.first_name, a1.last_name", nativeQuery = true)
    List<Query36> query36();

    @Query(value = "SELECT DISTINCT a.first_name, a.last_name " +
            "FROM actor a " +
            "JOIN film_actor fa1 ON a.actor_id = fa1.actor_id " +
            "JOIN film f1 ON fa1.film_id = f1.film_id " +
            "JOIN film_actor fa2 ON a.actor_id = fa2.actor_id " +
            "JOIN film f2 ON fa2.film_id = f2.film_id " +
            "WHERE (f1.rating = 'PG-13' AND f1.length > 120) " +
            "  AND (f2.rating = 'R' AND f2.length < 90)", nativeQuery = true)
    List<Query310> query310();
}
