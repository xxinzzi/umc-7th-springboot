package umc.spring.converter;

import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.web.dto.ReviewResponseDTO;
import umc.spring.web.dto.ReviewRequestDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResponseDTO.AddReviewToRestaurantResultDto toReviewResultDto(Review review){
        return ReviewResponseDTO.AddReviewToRestaurantResultDto.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.AddReviewToRestaurantDto request, Restaurant restaurant, User user){
        return Review.builder()
                .user(user)
                .restaurant(restaurant)
                .rating(request.getRating())
                .title(request.getTitle())
                .body(request.getBody())
                .build();
    }
}
