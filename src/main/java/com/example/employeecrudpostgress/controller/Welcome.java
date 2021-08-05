package com.example.employeecrudpostgress.controller;

import com.example.employeecrudpostgress.model.Product;
import com.example.employeecrudpostgress.repository.ProductRepository;
import com.example.employeecrudpostgress.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class Welcome {
    @Autowired
    private ProductService productService;
    // inject via application.properties
    @Value("${welcome.message}")
    private String message;

    private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);
        List<Product> products = productService.listAll();
        model.addAttribute("products", products);


        return "welcome";
    }
}
