package com.codecool.transaction_service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ProductCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${product.url}")
    private String url;

    public void deleteProduct(Long productId) {
        log.warn("================ delete started on  => " + url + "/" + productId );
        restTemplate.exchange("http://localhost:8081/" + productId, HttpMethod.DELETE, null, String.class);
        //restTemplate.exchange(url + "/" + productId, HttpMethod.DELETE, null, String.class);
        //restTemplate.delete(url + "/" + productId);
    }
}
