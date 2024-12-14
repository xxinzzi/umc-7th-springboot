package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.RestaurantConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.service.ReviewService.ReviewQueryService;
import umc.spring.validation.annotation.ExistRestaurants;
import umc.spring.validation.annotation.ExistUsers;
import umc.spring.web.dto.Restuarant.RestaurantRequestDTO;
import umc.spring.web.dto.Restuarant.RestaurantResponseDTO;
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
