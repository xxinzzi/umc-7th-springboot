package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.web.dto.Mission.MissionRequestDTO;
import umc.spring.web.dto.Mission.MissionResponseDTO;
import umc.spring.web.dto.Review.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .restaurantInfo(
                        MissionResponseDTO.RestaurantInfoDTO.builder()
                                .restaurantId(mission.getRestaurant().getId())
                                .restaurantName(mission.getRestaurant().getName())
                                .build()
                )
                .missionSpec(mission.getMissionSpec())
                .point(mission.getPoint())
                .deadline(mission.getDeadline())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public static MissionResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList){

        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}