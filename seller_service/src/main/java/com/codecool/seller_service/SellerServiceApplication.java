package com.codecool.seller_service;

import com.codecool.seller_service.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SellerServiceApplication {

    @Autowired
    SellerRepository sellerRepository;

    public static void main(String[] args) {
        SpringApplication.run(SellerServiceApplication.class, args);
    }

}
