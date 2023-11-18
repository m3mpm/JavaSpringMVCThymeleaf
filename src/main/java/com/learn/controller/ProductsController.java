package com.learn.controller;

import org.springframework.ui.Model;
import com.learn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ProductsController {
    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String viewProduct(Model page){
        var products = productService.findAll();
        page.addAttribute("products",products);
        return "products";
    }
}
