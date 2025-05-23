package site.rainbowx.FinalBackEnd.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {

    @NotBlank(message = "用户名不能为空")
    private String email;

    @NotBlank(message = "密码不能为空")
    private String password;

    private String fullName;
}
