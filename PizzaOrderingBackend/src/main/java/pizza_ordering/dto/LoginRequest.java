package pizza_ordering.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank(message = "Email field cannot be empty")
    @Email(message = "Invalid Email Format")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    private String password;
}
