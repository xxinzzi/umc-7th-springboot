package umc.spring.web.dto.UserMission;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class UserMissionRequestDTO {
    @Getter
    public static class challengeUserMissionDTO {
        @NotNull
        Long userID;
        @NotNull
        Long missionID;
    }
}
