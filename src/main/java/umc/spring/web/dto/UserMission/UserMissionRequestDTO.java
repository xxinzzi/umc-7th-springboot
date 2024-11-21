package umc.spring.web.dto.UserMission;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class UserMissionRequestDTO {
    @Getter
    public static class challengeUserMissionDto {
        @NotNull
        Long userID;
        @NotNull
        Long missionID;
    }
}
