package pizza_ordering.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name",nullable = false)
    private String productName;

    @Column(name = "product_price",nullable = false)
    private Double price;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    @JoinColumn(name = "category_id",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Categories category;

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable;

}
