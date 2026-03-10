package pizza_ordering.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pizza_ordering.dto.AddToCartRequest;
import pizza_ordering.dto.CartItemResponse;
import pizza_ordering.entity.*;
import pizza_ordering.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        if (product.getStockQuantity() < request.getQuantity()) {
            throw new RuntimeException("Not enough stock available");
        }

        Optional<CartItems> existingItem =
                cartItemRepository.findByCartAndProduct(cart, product);

        if (existingItem.isPresent()) {

            CartItems item = existingItem.get();
            item.setQuantity(item.getQuantity() + request.getQuantity());

            cartItemRepository.save(item);

        } else {

            CartItems item = new CartItems();
            item.setCart(cart);
            item.setProduct(product);
            item.setQuantity(request.getQuantity());
            item.setPriceAtTime(product.getPrice());

            cartItemRepository.save(item);
        }
    }

    public List<CartItemResponse> getCart(User user){

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        List<CartItems> items = cartItemRepository.findByCart(cart);

        List<CartItemResponse> responses = new ArrayList<>();

        for(CartItems item : items){

            CartItemResponse response = new CartItemResponse();

            response.setProductId(item.getProduct().getProductId());
            response.setProductName(item.getProduct().getProductName());
            response.setPrice(item.getPriceAtTime());
            response.setQuantity(item.getQuantity());

            double total = item.getPriceAtTime() * item.getQuantity();
            response.setTotalPrice(total);

            responses.add(response);
        }

        return responses;
    }
}