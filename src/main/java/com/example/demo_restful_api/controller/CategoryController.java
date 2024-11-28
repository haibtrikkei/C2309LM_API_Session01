package com.example.demo_restful_api.controller;

import com.example.demo_restful_api.model.entity.Category;
import com.example.demo_restful_api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> insertCategory(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.insert(category),HttpStatus.CREATED);
    }
}
