package pizza_ordering.dto;

import lombok.Data;

@Data
public class ProductRequest {
    private String productName;
    private Double price;
    private Integer stockQuantity;
    private Long categoryId;
}
