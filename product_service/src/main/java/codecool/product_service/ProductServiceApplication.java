package codecool.product_service;

import codecool.product_service.model.Condition;
import codecool.product_service.model.Product;
import codecool.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.Arrays;

@SpringBootApplication
@EnableEurekaClient

public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    ProductRepository productRepository;

    @PostConstruct
    public void asd() {
        productRepository.save(Product.builder()
                .condition(Condition.NEW).description("asd").name("rák1").pictureUrl("https://i.imgur.com/R2YGFZw.png").sellerDetailId(1L).price(BigInteger.valueOf(5L)).build());
        productRepository.save(Product.builder()
                .condition(Condition.NEW).description("dsa").name("rák2").pictureUrl("https://i.imgur.com/R2YGFZw.png").sellerDetailId(1L).price(BigInteger.valueOf(5L)).build());
    }
}
