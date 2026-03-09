package pizza_ordering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pizza_ordering.entity.Cart;
import pizza_ordering.entity.CartItems;
import java.util.List;


public interface CartItemRepository extends JpaRepository<CartItems, Integer> {
    List<CartItems> findByCart(Cart cart);
}
