package pizza_ordering.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductResponse {
    private Long productId;
    private String productName;
    private Double price;
    private Integer stockQuantity;
    private Boolean isAvailable;

    private Long categoryId;
    private String categoryName;
}
