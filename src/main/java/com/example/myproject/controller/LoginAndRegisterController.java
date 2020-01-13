package com.example.myproject.controller;

import com.example.myproject.domain.User;
import com.example.myproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    //Какая - то ебаная ошибка

  /*  @PostMapping("login")
    public String login(@RequestParam("login") String login,
            @RequestParam("password") String password){
        System.out.println(login + " " + password);
        return "login";
    }*/

    @GetMapping("registration")
    public String registration( Model model){
        User user = userRepo.findByUsername("admin");
        model.addAttribute("id", user.getId());
        return "registration";
    }
}
