package umc.spring.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.service.ReviewService.ReviewQueryService;
import umc.spring.validation.annotation.ExistRestaurants;
import umc.spring.web.dto.Mission.MissionResponseDTO;
import umc.spring.web.dto.Review.ReviewResponseDTO;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantRestController {
    private final MissionQueryService missionQueryService;
    private final ReviewQueryService reviewQueryService;

    @GetMapping("/{restaurantId}/reviews")
    @Operation(summary = "가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistRestaurants @PathVariable(name = "restaurantId") Long restaurantId, @RequestParam(name = "page") Integer page){
        // Service 호출로 reviewList 값을 반환받음
        Page<Review> reviewList = reviewQueryService.getRestaurantReviewList(restaurantId, page);

        // DTO로 변환
        ReviewResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO = ReviewConverter.reviewPreViewListDTO(reviewList);

        // 성공 응답 반환
        return ApiResponse.onSuccess(reviewPreViewListDTO);
    }

    @GetMapping("/{restaurantId}/missions")
    @Operation(summary = "가게의 미션 목록 조회 API", description = "가게의 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String으로 page 번호를 주세요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getRestaurantMissionList(
            @ExistRestaurants @PathVariable(name = "restaurantId") Long restaurantId,
            @RequestParam(name = "page") Integer page) {

        // Service 호출로 missionList 값을 반환받음
        Page<Mission> missionList = missionQueryService.getRestaurantMissionList(restaurantId, page);

        // DTO로 변환
        MissionResponseDTO.MissionPreViewListDTO missionPreViewListDTO = MissionConverter.missionPreViewListDTO(missionList);

        // 성공 응답 반환
        return ApiResponse.onSuccess(missionPreViewListDTO);
    }
}