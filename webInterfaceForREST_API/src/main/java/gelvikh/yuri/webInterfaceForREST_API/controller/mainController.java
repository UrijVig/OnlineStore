package gelvikh.yuri.webInterfaceForREST_API.controller;

import gelvikh.yuri.webInterfaceForREST_API.model.ShopUser;
import gelvikh.yuri.webInterfaceForREST_API.service.UserManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class mainController {

    private final UserManagerService userManagerService;
    @GetMapping("/admin/personal_area")
    public String admin_personal_area(){
        return "administration/administrator-personal-account";
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
        } else return "redirect:/auth";
    }
    @GetMapping("/auth")
    public String auth(){
        return "main/auth";
    }
    @GetMapping("/register")
    public String registerForm(){
        return "main/register";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute ShopUser newUser, RedirectAttributes redirectAttributes){
        try {
            userManagerService.save(newUser);
            return "redirect:/personal_area";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/register";
        }

    }


}
