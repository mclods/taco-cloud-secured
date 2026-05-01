package com.mclods.taco_cloud_secured.controllers;

import com.mclods.taco_cloud_secured.dtos.RegistrationForm;
import com.mclods.taco_cloud_secured.entities.User;
import com.mclods.taco_cloud_secured.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/register")
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "registrationForm";
    }

    @PostMapping
    public String processRegistration(@ModelAttribute RegistrationForm registrationForm) {
        User user = registrationForm.toUser();
        userService.saveUser(user);
        return "redirect:/login";
    }
}
