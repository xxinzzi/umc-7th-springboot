package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponseDTO.JoinResultDTO toJoinResultDTO(Mission mission){
        return MissionResponseDTO.JoinResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}