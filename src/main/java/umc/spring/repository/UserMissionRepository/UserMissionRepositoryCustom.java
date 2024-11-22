package umc.spring.repository.UserMissionRepository;

import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.mapping.UserMission;

import java.util.List;

public interface UserMissionRepositoryCustom {
    List<UserMission> dynamicQueryWithBooleanBuilder(Long userId, Boolean isSuccess);
}
