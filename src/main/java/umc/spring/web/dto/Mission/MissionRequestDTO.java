package umc.spring.web.dto.Mission;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;
import umc.spring.validation.annotation.ExistRetaurants;

import java.time.LocalDate;
import java.util.List;

public class MissionRequestDTO {
    @Getter
    public static class AddMissionToRestaurantDto{
        @ExistRetaurants
        Long restaurantId;
        @NotNull
        String missionSpec;
        @NotNull
        Integer point;
        @NotNull
        LocalDate deadline;
    }
}
