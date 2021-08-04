package com.example.employeecrudpostgress.controller;

import com.example.employeecrudpostgress.model.Product;
import com.example.employeecrudpostgress.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Get Products
    @GetMapping("products")
    public List<Product> getAllProducts() { return this.productRepository.findAll(); }

    // save employee
    @PostMapping("products")
    public Product createProduct(@RequestBody Product product) { return this.productRepository.save(product); }
}
