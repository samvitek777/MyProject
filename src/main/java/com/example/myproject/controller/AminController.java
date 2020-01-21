package com.example.myproject.controller;

import com.example.myproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AminController {

    @Autowired
    private UserService userSevice;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("users", userSevice.findAll());

        return "userList";
    }
}
