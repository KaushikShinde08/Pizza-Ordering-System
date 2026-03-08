package pizza_ordering.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name",nullable = false)
    private String productName;

    @Column(name = "description",nullable = false)
    private String  description;

    @Column(name = "category_id",nullable = false,unique = true)
    @ManyToOne
    private Categories categoryId;

    @Column(name = "product_price",nullable = false)
    private double price;

    @Column(name = "stock_quantity",nullable = false)
    private Long stockQuantity;

}
