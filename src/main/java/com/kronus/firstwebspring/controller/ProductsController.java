package com.kronus.firstwebspring.controller;

import com.kronus.firstwebspring.model.Products;
import com.kronus.firstwebspring.service.ProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductsController {
    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        List<Products> products = productsService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }

    @PostMapping("/products")
    public String addProducts(@RequestParam String name,
                              @RequestParam String price,
                              Model model) {
        Products p = new Products();
        p.setName(name);
        p.setPrice(price);
        productsService.addProducts(p);

        List<Products> products = productsService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }
}