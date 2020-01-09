package codecool.product_service.service;

import codecool.product_service.model.SellerDetail;
import codecool.product_service.model.request_response.ProductWithSellerDetail;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@Data
public class SellerService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.seller.url}")
    private String baseUrl;

    public SellerDetail addSeller(ProductWithSellerDetail productWithSellerDetail) throws JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject sellerJsonObject = new JSONObject();
        sellerJsonObject.put("name", productWithSellerDetail.getSellerName());
        sellerJsonObject.put("phoneNumber", productWithSellerDetail.getPhoneNumber());
        sellerJsonObject.put("email", productWithSellerDetail.getEmail());


        HttpEntity<String> request =
                new HttpEntity<String>(sellerJsonObject.toString(), headers);

        return restTemplate.postForEntity(baseUrl, request, SellerDetail.class).getBody();
    }

    public void deleteSellerById(Long sellerId) {
        restTemplate.delete(baseUrl + "/" + sellerId);
    }

    public SellerDetail getSellerById(Long id) {
        String fetchUrl = baseUrl + "/" + id;
        log.warn(fetchUrl);
        SellerDetail body = restTemplate.getForEntity(
                fetchUrl,
                SellerDetail.class).getBody();

        return body;
    }

}
