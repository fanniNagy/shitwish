package codecool.product_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SellerDetail {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
}
