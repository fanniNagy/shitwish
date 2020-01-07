package com.codecool.transaction_service;

import com.codecool.transaction_service.model.Transaction;
import com.codecool.transaction_service.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
public class TransactionServiceApplication {

    @Autowired
    private TransactionRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(TransactionServiceApplication.class, args);
    }

    @PostConstruct
    public void initializeData(){
        Transaction transaction1 = Transaction.builder()
                .buyer("Gerzson Lakatos")
                .date(new Date())
                .productName("Bojler")
                .seller("Kolompár Vinettu")
                .productPrice(BigInteger.valueOf(5000L))
                .build();
        repository.save(transaction1);

    }
}
