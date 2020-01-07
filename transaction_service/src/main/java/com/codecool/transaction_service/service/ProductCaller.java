package com.codecool.transaction_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${product.url}")
    private String url;

    public void deleteProduction(Long productId) {
        restTemplate.delete(url + productId);
    }
}
