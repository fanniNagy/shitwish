package com.codecool.transaction_service.controller;

import com.codecool.transaction_service.model.Transaction;
import com.codecool.transaction_service.model.TransactionFromBody;
import com.codecool.transaction_service.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@CrossOrigin
@Slf4j
public class TransactionController {

    @Autowired
    TransactionService service;

    @GetMapping("/all")
    public List<Transaction> getAllTransactions(){
        return service.getAllTransactions();
    }

    @PostMapping("/new")
    public void addNewTransaction(@RequestBody TransactionFromBody transaction){
        log.warn("3===========================================================================================D");
        log.warn(transaction.toString());
        service.addNewTransaction(transaction);
    }
}
