package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.web.dto.Mission.MissionRequestDTO;
import umc.spring.web.dto.Mission.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponseDTO.AddMissionToRestaurantResultDTO toJoinResultDTO(Mission mission){
        return MissionResponseDTO.AddMissionToRestaurantResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.AddMissionToRestaurantDto request, Restaurant restaurant){

        return Mission.builder()
                .restaurant(restaurant)
                .missionSpec(request.getMissionSpec())
                .point(request.getPoint())
                .deadline(request.getDeadline())
                .build();
    }
}