package umc.spring.service.MissionService;

import org.springframework.transaction.annotation.Transactional;
import umc.spring.web.dto.Mission.MissionRequestDTO;
import umc.spring.domain.Mission;

public interface MissionCommandService {
    @Transactional
    Mission addMissionToRestaurant(MissionRequestDTO.AddMissionToRestaurantDto request);
}
