package pizza_ordering.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pizza_ordering.entity.Orders;
import pizza_ordering.entity.User;
import pizza_ordering.service.OrderService;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Orders placeOrder(){

        User user = getCurrentUser();

        return orderService.placeOrder(user);
    }

}