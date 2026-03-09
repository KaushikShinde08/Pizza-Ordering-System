package pizza_ordering.service;

import pizza_ordering.dto.ProductRequest;
import pizza_ordering.entity.Product;
import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequest request);
    List<Product> getAllProducts();
    Product getProductById(Long ProductId);
    Product updateProduct(Long ProductId, ProductRequest request);
    void deleteProduct(Long ProductId);
}
