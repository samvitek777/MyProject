package com.example.myproject.controller;

import com.example.myproject.domain.Products;
import com.example.myproject.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/** Main controller
 *
 * @author Samoylenko Victor
 * @version 1.1
 */

@Controller
public class MainController {

    @Autowired
    private ProductsRepo productsRepo;

    @GetMapping("/")
    public String Index(Model model){

        Iterable<Products> products = productsRepo.findAll();
        model.addAttribute("products", products);

        return "index";
    }
}
