package pizza_ordering.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import pizza_ordering.entity.Role;

@Data
public class SignupRequest {

    @NotBlank(message = "username cannot be empty")
    private String username;

    @NotBlank(message = "Email field cannot be empty")
    @Email(message = "Invalid Email Format")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6,max = 20,message = "Password must be between 6 and 20 characters")
    private String password;

    @NotNull(message = "Please add your role")
    private Role role;

}
