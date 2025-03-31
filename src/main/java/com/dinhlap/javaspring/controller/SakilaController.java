package com.dinhlap.javaspring.controller;

import com.dinhlap.javaspring.repository.sakila.ActorRepository;
import com.dinhlap.javaspring.repository.sakila.CustomerRepository;
import com.dinhlap.javaspring.repository.sakila.FilmCategoryRepository;
import com.dinhlap.javaspring.repository.sakila.FilmRepository;
import com.dinhlap.javaspring.repository.sakila.RentalRepository;
import com.dinhlap.javaspring.repository.sakila.StoreRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/sakila")
@Tag(name = "Sakila", description = "APIs for Sakila")
public class SakilaController {
    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private FilmCategoryRepository filmCategoryRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private RentalRepository rentalRepository;

    @GetMapping("/query-1-1")
    public ResponseEntity<?> query1_1() {
        return ResponseEntity.ok(actorRepository.query11());
    }

    @GetMapping("/query-1-2")
    public ResponseEntity<?> query1_2() {
        return ResponseEntity.ok(filmRepository.queryOneTow());
    }

    @GetMapping("/query-1-3")
    public ResponseEntity<?> query1_3() {
        return ResponseEntity.ok(filmRepository.findTop5MostRentedFilms());
    }

    @GetMapping("/query-1-4")
    public ResponseEntity<?> query1_4() {
        return ResponseEntity.ok(filmCategoryRepository.query14());
    }

    @GetMapping("/query-1-5")
    public ResponseEntity<?> query1_5() {
        LocalDateTime startDate = LocalDateTime.of(2022, 1, 1, 0, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2022, 1, 31, 23, 59, 59);
        return ResponseEntity.ok(customerRepository.query15(startDate, endDate));
    }

    @GetMapping("/query-1-6")
    public ResponseEntity<?> query1_6() {
        return ResponseEntity.ok(storeRepository.query16());
    }

    @GetMapping("/query-1-7")
    public ResponseEntity<?> query1_7() {
        return ResponseEntity.ok(actorRepository.query17());
    }

    @GetMapping("/query-1-8")
    public ResponseEntity<?> query1_8() {
        return ResponseEntity.ok(filmRepository.query18());
    }

    @GetMapping("/query-2-1")
    public ResponseEntity<?> query2_1() {
        return ResponseEntity.ok(customerRepository.query21());
    }

    @GetMapping("/query-2-2")
    public ResponseEntity<?> query2_2() {
        return ResponseEntity.ok(customerRepository.query22());
    }

    @GetMapping("/query-2-3")
    public ResponseEntity<?> query2_3() {
        return ResponseEntity.ok(filmRepository.query23());
    }

    @GetMapping("/query-2-4")
    public ResponseEntity<?> query2_4() {
        return ResponseEntity.ok(actorRepository.query24());
    }

    @GetMapping("/query-2-5")
    public ResponseEntity<?> query2_5() {
        return ResponseEntity.ok(customerRepository.query25());
    }

    @GetMapping("/query-2-6")
    public ResponseEntity<?> query2_6() {
        return ResponseEntity.ok(actorRepository.query26());
    }

    @GetMapping("/query-2-7")
    public ResponseEntity<?> query2_7() {
        return ResponseEntity.ok(actorRepository.query27());
    }

    @GetMapping("/query-2-8")
    public ResponseEntity<?> query2_8() {
        return ResponseEntity.ok(filmRepository.query28());
    }

    @GetMapping("/query-2-9")
    public ResponseEntity<?> query2_9() {
        return ResponseEntity.ok(customerRepository.query29());
    }

    @GetMapping("/query-2-10")
    public ResponseEntity<?> query2_10() {
        return ResponseEntity.ok(filmRepository.query210());
    }

    @GetMapping("/query-3-1")
    public ResponseEntity<?> query3_1() {
        return ResponseEntity.ok(actorRepository.query31());
    }

    @GetMapping("/query-3-2")
    public ResponseEntity<?> query3_2() {
        return ResponseEntity.ok(actorRepository.query32());
    }

    @GetMapping("/query-3-3")
    public ResponseEntity<?> query3_3() {
        return ResponseEntity.ok(customerRepository.query33());
    }

    @GetMapping("/query-3-4")
    public ResponseEntity<?> query3_4() {
        return ResponseEntity.ok(customerRepository.query34());
    }

    @GetMapping("/query-3-5")
    public ResponseEntity<?> query3_5() {
        return ResponseEntity.ok(rentalRepository.query35());
    }

    @GetMapping("/query-3-6")
    public ResponseEntity<?> query3_6() {
        return ResponseEntity.ok(actorRepository.query36());
    }

    @GetMapping("/query-3-7")
    public ResponseEntity<?> query3_7() {
        return ResponseEntity.ok(customerRepository.query37());
    }

    @GetMapping("/query-3-8")
    public ResponseEntity<?> query3_8() {
        return ResponseEntity.ok(filmRepository.query38());
    }

    @GetMapping("/query-3-9")
    public ResponseEntity<?> query3_9() {
        return ResponseEntity.ok(customerRepository.query39());
    }

    @GetMapping("/query-3-10")
    public ResponseEntity<?> query3_10() {
        return ResponseEntity.ok(actorRepository.query310());
    }

    @GetMapping("/query-4-1")
    public ResponseEntity<?> query4_1() {
        return ResponseEntity.ok(filmRepository.query41());
    }

    @GetMapping("/query-4-2")
    public ResponseEntity<?> query4_2() {
        return ResponseEntity.ok(filmRepository.query42());
    }

    @GetMapping("/query-4-3")
    public ResponseEntity<?> query4_3() {
        return ResponseEntity.ok(filmRepository.query43());
    }

    @GetMapping("/query-4-4")
    public ResponseEntity<?> query4_4() {
        return ResponseEntity.ok(customerRepository.query44());
    }

    @GetMapping("/query-4-5")
    public ResponseEntity<?> query4_5() {
        return ResponseEntity.ok(filmRepository.query45());
    }

    @GetMapping("/query-4-6")
    public ResponseEntity<?> query4_6() {
        return ResponseEntity.ok(filmRepository.query46());
    }

    @GetMapping("/query-4-7")
    public ResponseEntity<?> query4_7() {
        return ResponseEntity.ok(filmRepository.query47());
    }

    @GetMapping("/query-4-8")
    public ResponseEntity<?> query4_8() {
        return ResponseEntity.ok(customerRepository.query48());
    }

    @GetMapping("/query-4-9")
    public ResponseEntity<?> query4_9() {
        return ResponseEntity.ok(filmRepository.query49());
    }

    @GetMapping("/query-4-10")
    public ResponseEntity<?> query4_10() {
        return ResponseEntity.ok(filmRepository.query410());
    }
}
