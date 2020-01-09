package codecool.product_service.model.request_response;

import codecool.product_service.model.Condition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductWithSellerDetail {

    private String productName;

    private String description;

    private Condition condition;

    private BigInteger price;

    private String pictureUrl;

    private String sellerName;

    private String phoneNumber;

    private String email;

}
