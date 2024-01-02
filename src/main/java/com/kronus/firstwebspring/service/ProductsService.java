package com.kronus.firstwebspring.service;

import com.kronus.firstwebspring.model.Products;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsService {
    private List<Products> products = new ArrayList<>();

    public void addProducts(Products p) {
        products.add(p);
    }

    public List<Products> findAll() {
        return products;
    }
}
