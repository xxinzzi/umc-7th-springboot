package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Mission;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.RestaurantRepository.RestaurantRepository;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public Page<Mission> getRestaurantMissionList(Long restaurantId, Integer page) {
        // 가게 존재 여부 확인
        restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));

        // 페이징 처리
        PageRequest pageRequest = PageRequest.of(page, 10);

        return missionRepository.findAllByRestaurantId(restaurantId, pageRequest);
    }

}
