package umc.spring.converter;

import umc.spring.domain.mapping.UserMission;
import umc.spring.web.dto.UserMission.UserMissionResponseDTO;
public class UserMissionConverter {
    public static UserMissionResponseDTO.challengeUserMissionResultDTO challengeUserMissionResultDto(UserMission userMission) {
        return UserMissionResponseDTO.challengeUserMissionResultDTO.builder()
                .missionId(userMission.getMission().getId()) // missionId 설정
                .isSuccess(userMission.isSuccess()) // isSuccess 설정
                .updatedAt(userMission.getUpdatedAt())
                .build();
    }
}
