package umc.spring.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import umc.spring.service.UserService.UserCommandService;
import umc.spring.web.dto.User.UserRequestDTO;
@Controller
public class UserViewController {
    private final UserCommandService userCommandService;

    public UserViewController(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    @PostMapping("/users/signup")
    public String joinUser(@ModelAttribute("userJoinDto") UserRequestDTO.JoinDto request, // 협업시에는 기존 RequestBody 어노테이션을 붙여주시면 됩니다!
                             BindingResult bindingResult,
                             Model model) {
        // 입력된 데이터 확인
        System.out.println("회원가입 요청 데이터: " + request);

        if (bindingResult.hasErrors()) {
            // 뷰에 데이터 바인딩이 실패할 경우 signup 페이지를 유지합니다.
            return "signup";
        }

        try {
            userCommandService.joinUser(request);
            return "redirect:/login";
        } catch (Exception e) {
            // 회원가입 과정에서 에러가 발생할 경우 에러 메시지를 보내고, signup 페이디를 유지합니다.
            model.addAttribute("error", e.getMessage());
            return "signup";
        }
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("userJoinDto", new UserRequestDTO.JoinDto());
        return "signup";
    }
    @GetMapping("/home")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            System.out.println("현재 인증 정보: " + authentication.getName());
        } else {
            System.out.println("인증 정보가 없습니다.");
        }
        return "home";
    }
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
