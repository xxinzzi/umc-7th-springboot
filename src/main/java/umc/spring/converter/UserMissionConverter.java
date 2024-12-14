package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.mapping.UserMission;
import umc.spring.web.dto.UserMission.UserMissionResponseDTO;

import java.util.List;

public class UserMissionConverter {
    public static UserMissionResponseDTO.challengeUserMissionResultDTO challengeUserMissionResultDto(UserMission userMission) {
        return UserMissionResponseDTO.challengeUserMissionResultDTO.builder()
                .missionId(userMission.getMission().getId()) // missionId 설정
                .isSuccess(userMission.isSuccess()) // isSuccess 설정
                .updatedAt(userMission.getUpdatedAt())
                .build();
    }

    public static UserMissionResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<UserMission> userMissionPage) {
        List<UserMissionResponseDTO.MissionPreViewDTO> missionPreViewDTOs = userMissionPage.stream()
                .map(userMission -> UserMissionResponseDTO.MissionPreViewDTO.builder()
                        .missionSpec(userMission.getMission().getMissionSpec())
                        .point(userMission.getMission().getPoint())
                        .deadline(userMission.getMission().getDeadline())
                        .createdAt(userMission.getMission().getCreatedAt().toLocalDate())
                        .isSuccess(userMission.isSuccess())
                        .build())
                .toList();

        // UserInfo 설정 (한 번만)
        UserMissionResponseDTO.UserInfoDTO userInfo = new UserMissionResponseDTO.UserInfoDTO(
                userMissionPage.getContent().get(0).getUser().getId(),
                userMissionPage.getContent().get(0).getUser().getName()
        );

        return UserMissionResponseDTO.MissionPreViewListDTO.builder()
                .userInfo(userInfo)
                .missionList(missionPreViewDTOs)
                .listSize(userMissionPage.getSize())
                .totalPage(userMissionPage.getTotalPages())
                .totalElements(userMissionPage.getTotalElements())
                .isFirst(userMissionPage.isFirst())
                .isLast(userMissionPage.isLast())
                .build();
    }
}
