package codecool.product_service.model.request;

import codecool.product_service.model.Condition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@Builder
public class RequestProduct {

    private String name;

    private String description;

    private Condition condition;

    private BigInteger price;

    private String pictureUrl;

}
