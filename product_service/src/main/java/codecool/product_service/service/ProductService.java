package codecool.product_service.service;

import codecool.product_service.model.Product;
import codecool.product_service.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ProductService {

    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) return product.get();
        throw new IllegalArgumentException();
    }

    public Product addProduct(Product product) {
        return productRepository.saveAndFlush(product);
    }

    public Product deleteProductById(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
        return product;
    }
}
