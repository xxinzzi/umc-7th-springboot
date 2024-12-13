package umc.spring.service.UserMissionService;

import umc.spring.domain.mapping.UserMission;
import umc.spring.web.dto.UserMission.UserMissionRequestDTO;

public interface UserMissionCommandService {
    UserMission challengeUserMission(UserMissionRequestDTO.challengeUserMissionDTO request, Long userId, Long missionId);
}
