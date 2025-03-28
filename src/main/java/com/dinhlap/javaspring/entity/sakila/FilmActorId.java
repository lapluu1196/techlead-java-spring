package com.dinhlap.javaspring.entity.sakila;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmActorId implements Serializable {

    private Integer actor;
    private Integer film;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorId that = (FilmActorId) o;
        return Objects.equals(actor, that.actor) && Objects.equals(film, that.film);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actor, film);
    }
}