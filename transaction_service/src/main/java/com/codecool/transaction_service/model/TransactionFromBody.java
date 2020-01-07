package com.codecool.transaction_service.model;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class TransactionFromBody {

    private Long productId;
    private String buyer;
    private String productName;
    private String seller;
    private Date date;
    private BigInteger productPrice;

}
