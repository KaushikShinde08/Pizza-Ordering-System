package pizza_ordering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pizza_ordering.entity.Cart;
import pizza_ordering.entity.CartItems;
import pizza_ordering.entity.OrderItems;
import pizza_ordering.entity.Orders;

import java.util.List;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer> {

    List<OrderItems> findByOrder(Orders order);
}
