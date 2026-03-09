package pizza_ordering.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pizza_ordering.dto.AddToCartRequest;
import pizza_ordering.entity.User;
import pizza_ordering.service.CartService;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/add")
    public String addToCart(@RequestBody AddToCartRequest request){

        User user = getCurrentUser();

        cartService.addToCart(user,request);

        return "Item added to cart";
    }

}