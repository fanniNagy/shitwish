package com.codecool.transaction_service.repository;

import com.codecool.transaction_service.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("Select transaction from Transaction transaction")
    List<Transaction> getAllTransaction();
}
