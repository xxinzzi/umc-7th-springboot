package umc.spring.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;

public interface ReviewQueryService {
    Page<Review> getRestaurantReviewList(Long restaurantId, Integer page);
    Page<Review> getUserReviewList(Long userId, Integer page);
}
