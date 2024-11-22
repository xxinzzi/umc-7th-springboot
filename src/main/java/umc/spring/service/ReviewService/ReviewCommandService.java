package umc.spring.service.ReviewService;


import umc.spring.domain.Review;
import umc.spring.web.dto.Review.ReviewRequestDTO;

public interface ReviewCommandService {
    public Review addReviewToRestaurant(ReviewRequestDTO.AddReviewToRestaurantDto request);
}
