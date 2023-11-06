package kz.dkazi.airastana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        System.out.println("Login page called");
        return "auth";
    }
}

