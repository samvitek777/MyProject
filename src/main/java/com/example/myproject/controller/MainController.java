package com.example.myproject.controller;

import com.example.myproject.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/** Main controller
 *
 * @author Samoylenko Victor
 * @version 1.0
 */

@Controller
public class MainController {

    @GetMapping("/")
    public String Index(){
        return "index";
    }
}
