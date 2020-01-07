package com.codecool.seller_service.controller;

import com.codecool.seller_service.model.Seller;
import com.codecool.seller_service.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerRepository sellerRepository;

    @GetMapping("/{id}")
    public Seller getSellerById(@PathVariable Long id) {
        return sellerRepository.findSellerById(id);
    }


}
