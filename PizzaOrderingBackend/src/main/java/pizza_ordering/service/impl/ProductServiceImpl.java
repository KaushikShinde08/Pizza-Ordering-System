package pizza_ordering.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pizza_ordering.dto.ProductRequest;
import pizza_ordering.repository.CategoryRepository;
import pizza_ordering.repository.ProductRepository;
import pizza_ordering.service.ProductService;
import pizza_ordering.entity.Categories;
import pizza_ordering.entity.Product;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product createProduct(ProductRequest request) {
        Categories category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found with id: " + request.getCategoryId()));

        Product product = Product.builder()
                .productName(request.getProductName())
                .price(request.getPrice())
                .stockQuantity(request.getStockQuantity())
                .category(category)
                .build();
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + productId));
    }

    @Override
    public Product updateProduct(Long productId, ProductRequest request) {

        Product product = getProductById(productId);

        product.setProductName(request.getProductName());
        product.setPrice(request.getPrice());
        product.setStockQuantity(request.getStockQuantity());

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {

        Product product = getProductById(productId);

        productRepository.delete(product);
    }

}
