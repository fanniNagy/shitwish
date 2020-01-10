package com.codecool.seller_service;

import com.codecool.seller_service.model.Seller;
import com.codecool.seller_service.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class DataInitializer implements CommandLineRunner {
    @Autowired
    SellerRepository sellerRepository;

    @Override
    public void run(String... args) throws Exception {
        sellerRepository.saveAndFlush(
                Seller.builder()
                        .name("Lakatos Gideon")
                        .email("laki.gidi@gmail.com")
                        .phoneNumber("06205437623")
                        .build()
        );


        sellerRepository.saveAndFlush(
                Seller.builder()
                        .name("Szabóné Kiss Valéria")
                        .email("huncutnagyi69@gmail.com")
                        .phoneNumber("06304759813")
                        .build()
        );

        sellerRepository.saveAndFlush(
                Seller.builder()
                        .name("Hunyadi Mátyás")
                        .email("hunyimatyi@gmail.com")
                        .phoneNumber("06707808310")
                        .build()
        );
    }
}
