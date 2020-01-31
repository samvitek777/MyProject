package com.example.myproject.controller;

import com.example.myproject.domain.Products;
import com.example.myproject.repository.ProductsRepo;
import com.example.myproject.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class ProductPageController {

    private ProductService productService;

    public ProductPageController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String productPage(@PathVariable("id") Long id, Model model){
        Products product = productService.getProductId(id);
        model.addAttribute("product", product);
        return "productPage";
    }

}
