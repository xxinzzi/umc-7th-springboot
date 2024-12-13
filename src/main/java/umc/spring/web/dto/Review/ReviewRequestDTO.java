package umc.spring.web.dto.Review;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistRetaurants;
import umc.spring.validation.annotation.ExistUsers;

public class ReviewRequestDTO {

    @Getter
    public static class AddReviewToRestaurantDto{
        @ExistUsers
        Long userId;
        @ExistRetaurants
        Long restaurantId;
        @NotNull
        String title;
        @NotNull
        String body;
        @NotNull
        Float rating;
    }
}
