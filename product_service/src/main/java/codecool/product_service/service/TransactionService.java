package codecool.product_service.service;

import codecool.product_service.model.Transaction;
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

import java.nio.charset.StandardCharsets;
import java.util.Collections;

@Service
@Slf4j
@Data
public class TransactionService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.transaction.url}")
    private String baseUrl;

    public void addTransaction(Transaction transaction) throws JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAcceptCharset(Collections.singletonList(StandardCharsets.UTF_8));

        JSONObject transactionJsonObject = new JSONObject();
        transactionJsonObject.put("productId", transaction.getProductId());
        transactionJsonObject.put("buyer", transaction.getBuyer());
        transactionJsonObject.put("productName", transaction.getProductName());
        transactionJsonObject.put("seller", transaction.getSeller());
        transactionJsonObject.put("date", transaction.getDate());
        transactionJsonObject.put("productPrice", transaction.getProductPrice());

        HttpEntity<String> request =
                new HttpEntity<String>(transactionJsonObject.toString(), headers);

        String fetchUrl = baseUrl + "/new";

        restTemplate.postForEntity(fetchUrl , request, String.class);
    }
}
