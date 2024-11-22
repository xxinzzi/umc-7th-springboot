package umc.spring.service.UserMissionService;

import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.apiPayload.exception.handler.UserHandler;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.mapping.UserMission;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.UserMissionRepository.UserMissionRepository;
import umc.spring.repository.UserRepository.UserRepository;
import umc.spring.web.dto.UserMission.UserMissionRequestDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService {
    private final UserRepository userRepository;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    @Transactional
    public UserMission challengeUserMission(UserMissionRequestDTO.challengeUserMissionDTO request,
                                            Long userId,
                                            Long missionId) {
        // User와 Mission 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        // 기존 UserMission 객체 생성
        UserMission userMission = UserMission.builder()
                .user(user)
                .mission(mission)
                .isSuccess(false) // 기본값
                .build();

        return userMissionRepository.save(userMission);
    }
}