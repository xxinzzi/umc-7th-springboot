package umc.spring.service.UserService;

import umc.spring.web.dto.User.UserRequestDTO;

public interface UserQueryService {

    void joinUser(UserRequestDTO.JoinDto request);
}
