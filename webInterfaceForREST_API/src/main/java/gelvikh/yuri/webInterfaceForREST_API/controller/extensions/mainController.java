package gelvikh.yuri.webInterfaceForREST_API.controller.extensions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class mainController {

    @GetMapping("/personal_area")
    public String personal_area(){
        return "administration/administrator-personal-account";
    }
    public String loginForm(){
        return "main/login";
    }
}
