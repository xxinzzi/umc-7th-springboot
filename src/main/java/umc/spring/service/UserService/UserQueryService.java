package umc.spring.service.UserService;

import umc.spring.domain.User;
import umc.spring.web.dto.UserRequestDTO;

public interface UserQueryService {

    void joinUser(UserRequestDTO.JoinDto request);
}
