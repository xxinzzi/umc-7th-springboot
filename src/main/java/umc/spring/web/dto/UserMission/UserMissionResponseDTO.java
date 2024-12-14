package umc.spring.web.dto.UserMission;

import lombok.*;
import umc.spring.web.dto.Mission.MissionResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UserMissionResponseDTO {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class challengeUserMissionResultDTO{
        Long missionId;
        Boolean isSuccess;
        LocalDateTime updatedAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewListDTO {
        UserMissionResponseDTO.UserInfoDTO userInfo;
        List<UserMissionResponseDTO.MissionPreViewDTO> missionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewDTO {
        String missionSpec;
        Integer point;
        LocalDate deadline;
        LocalDate createdAt;
        Boolean isSuccess;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInfoDTO {
        Long userId;
        String userName;
    }
}
