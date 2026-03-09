package pizza_ordering.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pizza_ordering.entity.Orders;
import pizza_ordering.entity.User;
import pizza_ordering.repository.UserRepository;
import pizza_ordering.service.OrderService;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserRepository userRepository;

    @PostMapping
    public Orders placeOrder(){

        User user = getCurrentUser();

        return orderService.placeOrder(user);
    }

    private User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email).orElseThrow();
    }

}