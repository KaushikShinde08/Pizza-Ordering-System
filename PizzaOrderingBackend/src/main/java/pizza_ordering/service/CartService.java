package pizza_ordering.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pizza_ordering.dto.AddToCartRequest;
import pizza_ordering.entity.*;
import pizza_ordering.repository.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    public void addToCart(User user, AddToCartRequest request) {

        Cart cart = cartRepository.findByUser(user)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUser(user);
                    return cartRepository.save(newCart);
                });

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItems item = new CartItems();
        item.setCart(cart);
        item.setProduct(product);
        item.setQuantity(request.getQuantity());
        item.setPriceAtTime(product.getPrice());

        cartItemRepository.save(item);
    }

    public List<CartItems> getCart(User user){

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        return cartItemRepository.findByCart(cart);
    }
}