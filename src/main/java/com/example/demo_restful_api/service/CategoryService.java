package com.example.demo_restful_api.service;

import com.example.demo_restful_api.model.entity.Category;

import java.util.List;

public interface CategoryService {
    Category insert(Category category);
    List<Category> findAll();
    Category update(String cateId, Category category);
    Category delete(String cateId);
}
