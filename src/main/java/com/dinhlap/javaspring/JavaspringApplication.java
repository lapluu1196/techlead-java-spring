package com.dinhlap.javaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class JavaspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaspringApplication.class, args);
    }

}
