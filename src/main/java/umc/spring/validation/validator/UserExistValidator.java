package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.repository.UserRepository.UserRepository;
import umc.spring.validation.annotation.ExistUsers;

@Component
@RequiredArgsConstructor
public class UserExistValidator implements ConstraintValidator<ExistUsers, Long> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(Long userId, ConstraintValidatorContext context) {
        // userId가 null이면 검증 실패
        if (userId == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("유저 ID가 null입니다.")
                    .addConstraintViolation();
            return false;
        }

        // userId가 존재하는지 확인
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("해당 ID에 해당하는 유저가 존재하지 않습니다.")
                    .addConstraintViolation();
        }

        return exists;
    }
}