package umc.spring.service.UserService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MenuCategoryHandler;
import umc.spring.converter.UserConverter;
import umc.spring.converter.UserPreferConverter;
import umc.spring.domain.MenuCategory;
import umc.spring.domain.User;
import umc.spring.domain.mapping.UserPrefer;
import umc.spring.repository.MenuCategoryRepository.MenuCategoryRepository;
import umc.spring.repository.UserRepository.UserRepository;
import umc.spring.web.dto.UserRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final MenuCategoryRepository menuCategoryRepository; // MenuCategoryRepository 의존성 주입

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDto request) {
        User newUser = UserConverter.toUser(request);

        // MenuCategory 리스트를 가져오기
        List<MenuCategory> menuCategoryList = request.getPreferCategory().stream()
                .map(categoryId ->
                        menuCategoryRepository.findById(categoryId)
                                .orElseThrow(() -> new MenuCategoryHandler(ErrorStatus.MENU_CATEGORY__NOT_FOUND))
                ).collect(Collectors.toList());

        // UserPrefer 리스트 생성
        List<UserPrefer> userPreferList = UserPreferConverter.toUserPreferList(menuCategoryList);

        // UserPrefer와 User 연관 설정
        userPreferList.forEach(userPrefer -> {
            userPrefer.setUser(newUser);
        });

        // User 저장
        return userRepository.save(newUser);
    }
}