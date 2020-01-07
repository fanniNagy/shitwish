package codecool.product_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class Transaction {
    private Long productId;
    private String buyer;
    private String productName;
    private String seller;
    private Date date;
    private BigInteger productPrice;
}
