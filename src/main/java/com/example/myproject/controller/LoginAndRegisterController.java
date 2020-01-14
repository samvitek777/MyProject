package com.example.myproject.controller;

import com.example.myproject.domain.User;
import com.example.myproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LoginAndRegisterController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @PostMapping("login")
    public String login1(@RequestParam String username,
                         @RequestParam String password){
        System.out.println(username + " " + password);
        return "redirect:";
    }

    @GetMapping("registration")
    public String registration( Model model){
        User user = userRepo.findByUsername("admin");
        model.addAttribute("id", user.getId());
        System.out.println(user.getId());
        return "registration";
    }

    @PostMapping("registration")
    public String addUser(User user, Model model){
        if(userRepo.findByUsername(user.getUsername()) != null){
            model.addAttribute("user", user.getUsername());
            return "test";
        } else {
            userRepo.save(user);
            return "redirect:";
        }
    }
}
