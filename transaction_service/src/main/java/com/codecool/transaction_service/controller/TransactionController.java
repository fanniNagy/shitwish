package com.codecool.transaction_service.controller;

import com.codecool.transaction_service.model.Transaction;
import com.codecool.transaction_service.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@CrossOrigin
public class TransactionController {

    @Autowired
    TransactionService service;

    @GetMapping("/all")
    public List<Transaction> getAllTransactions(){
        return service.getAllTransactions();
    }


}
