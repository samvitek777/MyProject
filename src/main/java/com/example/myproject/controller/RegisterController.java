package com.example.myproject.controller;

import com.example.myproject.domain.User;
import com.example.myproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/** Controller for {@link User} login and registration
 *
 * @author Samoylenko Victor
 * @version 1.0
 */

@Controller
public class RegisterController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("registration")
    public String registration( Model model){
        return "registration";
    }

    @PostMapping("registration")
    public String addUser(User user, Model model){
        if(userRepo.findByUsername(user.getUsername()) != null){
            model.addAttribute("user", user.getUsername());
            return "test";
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
            return "redirect:";
        }
    }
}
