package pizza_ordering.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pizza_ordering.dto.ProductRequest;
import pizza_ordering.dto.ProductResponse;
import pizza_ordering.service.ProductService;
import pizza_ordering.dto.ProductRequest;
import pizza_ordering.entity.Product;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest request) {
        return productService.createProduct(request);
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable Long id,
                                 @RequestBody ProductRequest request) {
        return productService.updateProduct(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductResponse> getProductsByCategory(@PathVariable Long categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    @PatchMapping("/{id}/stock")
    public ProductResponse updateStock(@PathVariable Long id,
                                       @RequestParam Integer quantity) {

        return productService.addStock(id, quantity);
    }


}
