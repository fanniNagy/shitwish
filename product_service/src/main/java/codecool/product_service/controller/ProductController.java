package codecool.product_service.controller;

import codecool.product_service.model.Product;
import codecool.product_service.model.request_response.Buyer;
import codecool.product_service.model.request_response.ProductWithSellerDetail;
import codecool.product_service.service.ProductService;
import codecool.product_service.service.SellerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@AllArgsConstructor
public class ProductController {

    ProductService productService;

    SellerService sellerService;

    @GetMapping
    List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    ProductWithSellerDetail getProductById(@PathVariable("id") Long id) {
        return productService.getProductWithSellerDetailById(id);
    }

    @PutMapping
    Product addProduct(@RequestBody ProductWithSellerDetail productWithSellerDetail) throws JSONException {
        return productService.addProduct(productWithSellerDetail);
    }

    @DeleteMapping("/{id}")
    Product deleteProductById(@PathVariable("id") Long id) {
        return productService.deleteProductById(id);
    }

    @PostMapping("/{id}/buy")
    void buyProduct(@PathVariable("id") Long id, @RequestBody Buyer buyer) throws JSONException {
        productService.buyProductById(id, buyer);
    }


}
