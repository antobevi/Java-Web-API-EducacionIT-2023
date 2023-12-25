package com.antobevi.JavaWebAPIEducacionIT2023.controller;

import com.antobevi.JavaWebAPIEducacionIT2023.model.WebAppUser;
import com.antobevi.JavaWebAPIEducacionIT2023.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new WebAppUser());

        return "login";
    }

    @PostMapping("/login")
    public String registerUser(WebAppUser webAppUser) {
        userService.saveUser(webAppUser);

        return "redirect:/api/login";
    }

}
