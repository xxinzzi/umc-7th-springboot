package umc.spring.web.dto.Review;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.spring.validation.annotation.ExistRestaurants;
import umc.spring.validation.annotation.ExistUsers;

public class ReviewRequestDTO {

    @Getter
    @Setter
    public static class AddReviewToRestaurantDto{
        @ExistUsers
        Long userId;
        @ExistRestaurants
        Long restaurantId;
        @NotNull
        String title;
        @NotNull
        String body;
        @NotNull
        Float rating;
    }
}
