package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.Review.ReviewResponseDTO;
import umc.spring.web.dto.Review.ReviewRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.AddReviewToRestaurantResultDto> addReview(@RequestBody @Valid ReviewRequestDTO.AddReviewToRestaurantDto request){
        Review review =reviewCommandService.addReviewToRestaurant(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDto(review));
    }
}
