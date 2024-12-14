package umc.spring.service.UserMissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.UserMission;

public interface UserMissionQueryService {
    Page<UserMission> getUserChallengingMissionList(Long userId, Boolean isSuccess, Integer page);
}
