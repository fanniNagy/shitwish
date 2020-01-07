package com.codecool.transaction_service.service;

import com.codecool.transaction_service.model.Transaction;
import com.codecool.transaction_service.model.TransactionFromBody;
import com.codecool.transaction_service.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private ProductCaller caller;

    public List<Transaction> getAllTransactions() {
        return repository.getAllTransaction();
    }

    public void addNewTransaction(TransactionFromBody transaction) {
        Long productId = transaction.getProductId();
        saveTransaction(transaction);
        caller.deleteProduction(productId);
    }

    private void saveTransaction(TransactionFromBody transaction) {
        Transaction newTransaction = Transaction.builder()
                .date(new Date())
                .buyer(transaction.getBuyer())
                .productName(transaction.getProductName())
                .seller(transaction.getSeller())
                .productPrice(transaction.getProductPrice())
                .build();
        repository.save(newTransaction);
    }
}
