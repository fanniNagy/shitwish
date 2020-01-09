package com.codecool.transaction_service.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class TransactionFromBody {

    private Long productId;
    private String buyer;
    private String productName;
    private String seller;
    private LocalDate date;
    private BigInteger productPrice;

}
