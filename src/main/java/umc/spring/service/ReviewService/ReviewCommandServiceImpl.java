package umc.spring.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RestaurantHandler;
import umc.spring.apiPayload.exception.handler.UserHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.repository.RestaurantRepository.RestaurantRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.UserRepository.UserRepository;
import umc.spring.web.dto.Review.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Review addReviewToRestaurant(ReviewRequestDTO.AddReviewToRestaurantDto request) {
        // 요청 DTO에서 올바른 식별자(ID) 추출
        Long restaurantId = request.getRestaurantId(); // restaurantId 추가 필요
        Long userId = request.getUserId(); // userId 추가 필요

        // 식당 검색
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        // 사용자 검색
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));

        // 리뷰 생성 및 저장
        Review newReview = ReviewConverter.toReview(request, restaurant, user);
        return reviewRepository.save(newReview);
    }
}