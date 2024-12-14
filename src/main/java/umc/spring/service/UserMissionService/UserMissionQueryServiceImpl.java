package umc.spring.service.UserMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import umc.spring.domain.mapping.UserMission;
import umc.spring.repository.UserMissionRepository.UserMissionRepository;
import umc.spring.repository.UserRepository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserMissionQueryServiceImpl implements UserMissionQueryService{
    private final UserMissionRepository userMissionRepository;
    private final UserRepository userRepository;

    public Page<UserMission> getUserChallengingMissionList(Long userId, Boolean isSuccess, Integer page) {
        // 유저 존재 여부 확인
        userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));

        // 페이징 처리
        PageRequest pageRequest = PageRequest.of(page, 10);

        // 쿼리 실행
        return userMissionRepository.findByUserIdAndIsSuccess(userId, isSuccess, pageRequest);
    }
}
