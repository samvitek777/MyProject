package com.example.myproject.services;

import com.example.myproject.domain.Products;
import com.example.myproject.repository.ProductsRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private ProductsRepo productsRepo;

    public ProductService(ProductsRepo productsRepo){
        this.productsRepo = productsRepo;
    }

    //Пока без проверки
    public Products getProductId(Long id){
        Optional<Products> product = productsRepo.findById(id);
        if(product.isPresent()){
            return product.get();
        } else {
            return null;
        }
    }

}
