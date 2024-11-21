package umc.spring.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.exception.handler.RestaurantHandler;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.RestaurantRepository.RestaurantRepository;
import umc.spring.web.dto.Mission.MissionRequestDTO;
import umc.spring.converter.MissionConverter;
import umc.spring.apiPayload.code.status.ErrorStatus;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{
    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    @Transactional
    public Mission addMissionToRestaurant(MissionRequestDTO.AddMissionToRestaurantDto request) {
        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(()-> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        Mission newMission = MissionConverter.toMission(request, restaurant);

        // Mission 저장
        return missionRepository.save(newMission);
    }
}