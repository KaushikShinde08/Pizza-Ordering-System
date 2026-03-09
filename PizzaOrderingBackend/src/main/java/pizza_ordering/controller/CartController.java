package pizza_ordering.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pizza_ordering.dto.AddToCartRequest;
import pizza_ordering.entity.User;
import pizza_ordering.repository.UserRepository;
import pizza_ordering.service.CartService;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final UserRepository userRepository;

    @PostMapping("/add")
    public String addToCart(@RequestBody AddToCartRequest request){

        User user = getCurrentUser();

        cartService.addToCart(user,request);

        return "Item added to cart";
    }

    private User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email).orElseThrow();
    }

}