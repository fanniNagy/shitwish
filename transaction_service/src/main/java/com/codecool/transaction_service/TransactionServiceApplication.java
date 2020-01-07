package com.codecool.transaction_service;

import com.codecool.transaction_service.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
//TODO ENABLE EU-RÉKA here and app.properties
public class TransactionServiceApplication {

    @Autowired
    private TransactionRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(TransactionServiceApplication.class, args);
    }

    @PostConstruct
    public void initializeData(){

    }
}
