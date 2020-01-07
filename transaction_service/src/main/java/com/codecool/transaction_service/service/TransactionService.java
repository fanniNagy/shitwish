package com.codecool.transaction_service.service;

import com.codecool.transaction_service.model.Transaction;
import com.codecool.transaction_service.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public List<Transaction> getAllTransactions() {
        return repository.getAllTransaction();
    }
}
