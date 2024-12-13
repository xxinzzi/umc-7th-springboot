package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.web.dto.Restuarant.RestaurantResponseDTO;
import umc.spring.web.dto.Review.ReviewResponseDTO;
import umc.spring.web.dto.Review.ReviewRequestDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static ReviewResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return ReviewResponseDTO.ReviewPreViewDTO.builder()
                .userInfo(
                        ReviewResponseDTO.UserInfoDTO.builder()
                                .ownerId(review.getUser().getId())
                                .ownerNickname(review.getUser().getNickname())
                                .build()
                )
                .rating(review.getRating())
                .createdAt(review.getCreatedAt().toLocalDate())
                .title(review.getTitle())
                .body(review.getBody())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<ReviewResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreViewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
