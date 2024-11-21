package umc.spring.web.dto.UserMission;

import lombok.*;

import java.time.LocalDateTime;

public class UserMissionResponseDTO {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class challengeUserMissionResultDto{
        Long missionId;
        Boolean isSuccess;
        LocalDateTime updatedAt;
    }
}
