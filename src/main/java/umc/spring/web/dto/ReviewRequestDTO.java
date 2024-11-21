package umc.spring.web.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class AddReviewToRestaurantDto{
        @NotNull
        Long userId;
        @NotNull
        Long restaurantId;
        @NotNull
        String body;
        @NotNull
        Float score;
    }
}
