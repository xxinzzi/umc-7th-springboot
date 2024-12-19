package umc.spring.web.dto.User;

import jakarta.validation.constraints.*;
import lombok.Getter;
import umc.spring.domain.enums.Role;
import umc.spring.validation.annotation.ExistCategories;

import java.time.LocalDate;
import java.util.List;

public class UserRequestDTO {
    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @Email
        String email;
        @NotBlank
        String password;
        @NotNull
        Integer gender;
        @NotNull
        LocalDate birth;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String addressSpec;
        @ExistCategories
        List<Long> preferCategory; //<Long> : 프론트에서 음식 카테고리의 id 값을 넘겨준다는 전제
        @NotNull
        Role role;
    }
}
