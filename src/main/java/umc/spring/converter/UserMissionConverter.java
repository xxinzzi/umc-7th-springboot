package umc.spring.converter;

import umc.spring.domain.mapping.UserMission;
import umc.spring.web.dto.UserMission.UserMissionResponseDTO;
public class UserMissionConverter {
    public static UserMissionResponseDTO.challengeUserMissionResultDto challengeUserMissionResultDto(UserMission userMission){
        return UserMissionResponseDTO.challengeUserMissionResultDto.builder()
                .updatedAt(userMission.getUpdatedAt())
                .build();
    }
}
