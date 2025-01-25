package com.example.bestpractices.adapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.bestpractices")
@EnableJpaRepositories(basePackages = "com.example.bestpractices.infrastructure.repository")
@EntityScan(basePackages = "com.example.bestpractices.infrastructure.entity")

public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
