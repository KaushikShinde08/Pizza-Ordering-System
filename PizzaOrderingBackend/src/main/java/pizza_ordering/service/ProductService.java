package pizza_ordering.service;

import pizza_ordering.dto.ProductRequest;
import pizza_ordering.dto.ProductResponse;
import pizza_ordering.entity.Product;
import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest request);
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(Long ProductId);
    ProductResponse updateProduct(Long ProductId, ProductRequest request);
    void deleteProduct(Long ProductId);
    List<ProductResponse> getProductsByCategory(Long categoryId);
    void reduceStock(Long productId, Integer quantity);
    ProductResponse addStock(Long productId, Integer quantity);
}
