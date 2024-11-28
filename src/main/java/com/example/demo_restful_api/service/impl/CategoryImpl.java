package com.example.demo_restful_api.service.impl;

import com.example.demo_restful_api.model.entity.Category;
import com.example.demo_restful_api.repository.CategoryRepository;
import com.example.demo_restful_api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category insert(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category update(String cateId, Category category) {
        categoryRepository.findById(cateId).orElseThrow(()->new NoSuchElementException("Khong ton tai category co id: "+cateId));
        category.setCateId(cateId);
        return categoryRepository.save(category);
    }

    @Override
    public Category delete(String cateId) {
        Category category = categoryRepository.findById(cateId).orElseThrow(() -> new NoSuchElementException("Khong ton tai category co id: " + cateId));
        categoryRepository.delete(category);
        return category;
    }
}
