package com.example.myproject.repository;

import com.example.myproject.domain.Products;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepo extends CrudRepository<Products, Long> {
}
