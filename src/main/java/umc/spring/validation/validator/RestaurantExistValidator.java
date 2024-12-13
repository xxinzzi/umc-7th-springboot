package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.repository.RestaurantRepository.RestaurantRepository;
import umc.spring.validation.annotation.ExistRestaurants;

@Component
@RequiredArgsConstructor
public class RestaurantExistValidator implements ConstraintValidator<ExistRestaurants, Long> {

    private final RestaurantRepository restaurantRepository;

    @Override
    public boolean isValid(Long restaurantId, ConstraintValidatorContext context) {
        // restaurantId가 null이면 검증 실패
        if (restaurantId == null) {
            return false;
        }

        // restaurantId가 존재하는지 확인
        return restaurantRepository.existsById(restaurantId);
    }
}