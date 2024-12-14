package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Review;
import umc.spring.repository.RestaurantRepository.RestaurantRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.UserRepository.UserRepository;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService{
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    @Override
    public Page<Review> getRestaurantReviewList(Long restaurantId, Integer page) {
        // 가게 존재 여부 확인
        restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));

        // 페이징 처리
        PageRequest pageRequest = PageRequest.of(page, 10);

        return reviewRepository.findAllByRestaurantId(restaurantId, pageRequest);
    }

    @Override
    public Page<Review> getUserReviewList(Long userId, Integer page) {
        // 유저 존재 여부 확인
        userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // 페이징 처리
        PageRequest pageRequest = PageRequest.of(page, 10);

        return reviewRepository.findAllByUserId(userId, pageRequest);
    }

}
