package pizza_ordering.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "user_id")
    private Long userId;

    @Column (name = "name",nullable = false)
    private String name;

    @Column (name = "email",nullable = false,unique = true)
    private String email;

    @Column (name = "password_hash",nullable = false)
    private String passwordHash;

    @Column(name = "roles",nullable = false)
    private Role role;

    @Column (name = "created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @Column (name = "status",nullable = false)
    private String status;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null){
            this.status = "Active";
        }
    }
}
