package com.example.front.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/logInPage")
    public String redirectLogInPage(){
        return "logInPage";
    }

    @GetMapping("/account/register")
    public String redirectToRegister(){
        return "/account/register";
    }
    @GetMapping("/account/changePassword")
    public String redirectToChangePassword(){
        return "/account/changePassword";
    }
}
