package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.UserConverter;
import umc.spring.converter.UserMissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.domain.mapping.UserMission;
import umc.spring.service.ReviewService.ReviewQueryService;
import umc.spring.service.UserMissionService.UserMissionCommandService;
import umc.spring.service.UserMissionService.UserMissionQueryService;
import umc.spring.service.UserService.UserCommandService;
import umc.spring.validation.annotation.ExistUsers;
import umc.spring.web.dto.Review.ReviewResponseDTO;
import umc.spring.web.dto.User.UserRequestDTO;
import umc.spring.web.dto.User.UserResponseDTO;
import umc.spring.web.dto.UserMission.UserMissionRequestDTO;
import umc.spring.web.dto.UserMission.UserMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {

    private final UserCommandService userCommandService;
    private final UserMissionCommandService userMissionCommandService; // UserMissionCommandService 주입
    private final ReviewQueryService reviewQueryService;
    private final UserMissionQueryService userMissionQueryService;

    // 회원 가입
    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDto request) {
        User user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }

    // 사용자 미션 도전
    @PostMapping("/{userId}/missions")
    public ApiResponse<UserMissionResponseDTO.challengeUserMissionResultDTO> challengeMission(
            @PathVariable Long userId,
            @RequestBody @Valid UserMissionRequestDTO.challengeUserMissionDTO request) {
        UserMission userMission = userMissionCommandService.challengeUserMission(request, userId, request.getMissionID());
        return ApiResponse.onSuccess(UserMissionResponseDTO.challengeUserMissionResultDTO.builder()
                .missionId(userMission.getMission().getId())
                .isSuccess(userMission.isSuccess())
                .updatedAt(userMission.getUpdatedAt())
                .build());
    }

    @GetMapping("/{userId}/reviews")
    @Operation(summary = "유저가 작성한 리뷰 목록 조회 API", description = "유저가 작성한 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String으로 page 번호를 주세요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "유저의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getUserReviewList(
            @ExistUsers @PathVariable(name = "userId") Long userId,
            @RequestParam(name = "page") Integer page) {

        // Service 호출로 reviewList 값을 반환받음
        Page<Review> reviewList = reviewQueryService.getUserReviewList(userId, page);

        // DTO로 변환
        ReviewResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO = ReviewConverter.reviewPreViewListDTO(reviewList);

        // 성공 응답 반환
        return ApiResponse.onSuccess(reviewPreViewListDTO);
    }

    @GetMapping("/{userId}/missions")
    @Operation(summary = "유저가 진행 중인 미션 목록 조회 API",
            description = "유저가 진행 중인 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. " +
                    "path variable로 userId를 받고, query parameter로 isSuccess와 page 번호를 전달합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "서버 에러")
    })
    public ApiResponse<UserMissionResponseDTO.MissionPreViewListDTO> getUserChallengingMissionList(
            @PathVariable Long userId,
            @RequestParam(required = false, defaultValue = "false") Boolean isSuccess,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {

        // 서비스 호출
        Page<UserMission> userMissionPage = userMissionQueryService.getUserChallengingMissionList(userId, isSuccess, page);

        // DTO 변환
        UserMissionResponseDTO.MissionPreViewListDTO missionPreViewListDTO = UserMissionConverter.missionPreViewListDTO(userMissionPage);

        return ApiResponse.onSuccess(missionPreViewListDTO);
    }
}