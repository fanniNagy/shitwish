package codecool.product_service.controller;

import codecool.product_service.model.Product;
import codecool.product_service.model.request.RequestProduct;
import codecool.product_service.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    ProductService productService;

    @GetMapping
    List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    Product addProduct(@RequestBody RequestProduct requestProduct) {
        return productService.addProduct(
                Product.builder()
                .name(requestProduct.getName())
                .condition(requestProduct.getCondition())
                .description(requestProduct.getDescription())
                .pictureUrl(requestProduct.getPictureUrl())
                .price(requestProduct.getPrice())
                .build()
        );
    }

    @DeleteMapping("/{id}")
    Product deleteProductById(@PathVariable("id") Long id) {
        return productService.deleteProductById(id);
    }


}
