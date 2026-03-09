package pizza_ordering.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pizza_ordering.entity.*;
import pizza_ordering.repository.*;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderRepository orderRepository;
    private final OrderItemsRepository orderItemRepository;

    public Orders placeOrder(User user){

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        List<CartItems> items = cartItemRepository.findByCart(cart);

        double total = 0;

        for(CartItems item : items){
            total += item.getQuantity() * item.getPriceAtTime();
        }

        Orders order = new Orders();

        order.setUser(user);
        order.setTotalAmount(total);
        order.setOrderStatus("PLACED");
        order.setOrderTime(LocalDateTime.now());

        orderRepository.save(order);

        for(CartItems item : items){

            OrderItems orderItem = new OrderItems();

            orderItem.setOrder(order);
            orderItem.setProduct(item.getProduct());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPriceAtPurchase(item.getPriceAtTime());

            orderItemRepository.save(orderItem);
        }

        cartItemRepository.deleteAll(items);

        return order;
    }

}