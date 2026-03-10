package pizza_ordering.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private Long userId;

    private Long orderId;

    private String status;

    private double totalAmount;

    private int totalQuantity;

    private List<OrderItemResponse> items;

}