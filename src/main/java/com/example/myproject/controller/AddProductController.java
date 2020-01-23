package com.example.myproject.controller;

import com.example.myproject.domain.Products;
import com.example.myproject.domain.User;
import com.example.myproject.repository.ProductsRepo;
import com.example.myproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import javax.validation.Valid;
import java.util.Optional;

@PreAuthorize("hasAnyAuthority('USER')")
@Controller
public class AddProductController {

    @Autowired
    private ProductsRepo productsRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/add")
    public String addPage(){
        return "add_page";
    }

    @PostMapping("/add")
    public String addProduct(@AuthenticationPrincipal User user,
                             @Valid Products products){

        //Костыль без него ошибка или сохраняет дубликат при @OneToOne(cascade = {CascadeType.ALL})
        // как я понял не хабернейт думает что этого юзера нет в бд и выдает ошибку
        Optional<User> optionalUser = userRepo.findById(user.getId());
        User user1 = optionalUser.isPresent() ? optionalUser.get() : null;
        products.setAuthor(user1);

        productsRepo.save(products);
        return "redirect:";
    }
}
