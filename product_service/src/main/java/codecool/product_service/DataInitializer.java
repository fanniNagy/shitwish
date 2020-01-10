package codecool.product_service;

import codecool.product_service.model.Condition;
import codecool.product_service.model.Product;
import codecool.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.math.BigInteger;

public class DataInitializer implements CommandLineRunner {
    @Autowired
    ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {
        productRepository.saveAndFlush(
                Product.builder()
                        .name("Fullos villany bojler")
                        .condition(Condition.USED_VERY_GOOD)
                        .price(BigInteger.valueOf(25000))
                        .description("Villamoson találtam, alig használt.")
                        .pictureUrl("https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.tarkovszkij.hu%2Fwp-content%2Fuploads%2F2015%2F03%2Felektromos-bojler.jpg&f=1&nofb=1")
                        .sellerDetailId(1L)
                        .build()
        );

        productRepository.saveAndFlush(
                Product.builder()
                        .name("Fagyasztott töltött káposzta")
                        .condition(Condition.USED_ACCEPTABLE)
                        .price(BigInteger.valueOf(1490))
                        .description("Teljesen jó, nincsen semmi baja ha lekaparod a penészt.")
                        .pictureUrl("https://artel1.ru/uploads/025c5c3f63a93070.jpg")
                        .sellerDetailId(2L)
                        .build()
        );

        productRepository.saveAndFlush(
                Product.builder()
                        .name("Karácsonyi pulcsi")
                        .condition(Condition.NEW)
                        .price(BigInteger.valueOf(1500))
                        .description("Kaptam oszt nemkell")
                        .pictureUrl("https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fthesipadvisor.files.wordpress.com%2F2013%2F12%2Fmy-ugly-christmas-sweater-light-up-the-party.jpg&f=1&nofb=1")
                        .sellerDetailId(3L)
                        .build()
        );
    }
}
