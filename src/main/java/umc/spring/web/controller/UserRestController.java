package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.*;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.UserConverter;
import umc.spring.domain.User;
import umc.spring.domain.mapping.UserMission;
import umc.spring.service.UserMissionService.UserMissionCommandService;
import umc.spring.service.UserService.UserCommandService;
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
}