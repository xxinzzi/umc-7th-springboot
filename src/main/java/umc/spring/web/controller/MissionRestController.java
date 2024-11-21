package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import org.springframework.web.bind.annotation.*;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.web.dto.MissionResponseDTO;
import umc.spring.web.dto.MissionRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.AddMissionToRestaurantResultDTO> join(@RequestBody @Valid MissionRequestDTO.AddMissionToRestaurantDto request){
        return null;
    }
}
