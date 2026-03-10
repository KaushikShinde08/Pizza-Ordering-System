package pizza_ordering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pizza_ordering.entity.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory_CategoryId(Long categoryId);
}
