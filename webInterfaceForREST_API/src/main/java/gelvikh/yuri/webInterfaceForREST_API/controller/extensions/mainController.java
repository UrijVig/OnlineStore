package gelvikh.yuri.webInterfaceForREST_API.controller.extensions;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping
public class mainController {

    @GetMapping("/admin/personal_area")
    public String admin_personal_area(){
        return "administration/administrator-personal-account";
    }

    @GetMapping("/user/personal_area")
    public String user_personal_area(){
        return "user/user-personal-account";
    }
    @GetMapping("/login")
    public String loginForm(){
        return "main/login";
    }

    @GetMapping("/personal_area")
    public String redirectByRole(Authentication auth) {
        if (auth != null){
            Set<String> roles = auth.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toSet());

            if (roles.contains("ROLE_ADMIN")) {
                return "redirect:/admin/personal_area";
            } else if (roles.contains("ROLE_USER")) {
                return "redirect:/user/personal_area";
            } else {
                return "redirect:/login";
            }
        } else return "redirect:/login";

    }
}
