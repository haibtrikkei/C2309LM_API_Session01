package com.example.demo_restful_api.service;

import com.example.demo_restful_api.model.entity.Category;
import com.example.demo_restful_api.model.entity.Product;

import java.util.List;

public interface ProductService {
    Product insert(Product product);
    List<Product> findAll();
    Product update(Integer proId, Product product);
    Product delete(Integer proId);
}
