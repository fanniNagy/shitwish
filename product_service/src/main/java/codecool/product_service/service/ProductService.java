package codecool.product_service.service;

import codecool.product_service.model.Product;
import codecool.product_service.model.SellerDetail;
import codecool.product_service.model.Transaction;
import codecool.product_service.model.request_response.Buyer;
import codecool.product_service.model.request_response.ProductWithSellerDetail;
import codecool.product_service.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ProductService {

    ProductRepository productRepository;

    SellerService sellerService;

    TransactionService transactionService;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductWithSellerDetail getProductWithSellerDetailById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        Product product;
        if (productOptional.isPresent()) product = productOptional.get();
        else throw new IllegalArgumentException();

        SellerDetail sellerDetail = sellerService.getSellerById(product.getId());

        return ProductWithSellerDetail.builder()
                .productName(product.getName())
                .description(product.getDescription())
                .condition(product.getCondition())
                .price(product.getPrice())
                .pictureUrl(product.getPictureUrl())
                .sellerName(sellerDetail.getName())
                .phoneNumber(sellerDetail.getPhoneNumber())
                .email(sellerDetail.getEmail())
                .build();
    }

    public Product addProduct(ProductWithSellerDetail productWithSellerDetail) throws JSONException {
        SellerDetail sellerDetail = sellerService.addSeller(productWithSellerDetail);
        return productRepository.saveAndFlush(
                Product.builder()
                        .name(productWithSellerDetail.getProductName())
                        .condition(productWithSellerDetail.getCondition())
                        .description(productWithSellerDetail.getDescription())
                        .pictureUrl(productWithSellerDetail.getPictureUrl())
                        .price(productWithSellerDetail.getPrice())
                        .sellerDetailId(sellerDetail.getId())
                        .build()
        );
    }

    public Product deleteProductById(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
        sellerService.deleteSellerById(product.getSellerDetailId());
        return product;
    }

    private Product getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) return productOptional.get();
        else throw new IllegalArgumentException();
    }

    public void buyProductById(Long id, Buyer buyer) throws JSONException {
        Product product = getProductById(id);
        SellerDetail sellerDetail = sellerService.getSellerById(product.getId());

        transactionService.addTransaction(
                Transaction.builder()
                .productId(product.getId())
                .buyer(buyer.getName())
                .productName(product.getName())
                .seller(sellerDetail.getName())
                .date(new Date())
                .productPrice(product.getPrice())
                .build()
        );
    }
}
