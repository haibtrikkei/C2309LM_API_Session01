package com.example.demo_restful_api.controller;

import com.example.demo_restful_api.model.entity.Product;
import com.example.demo_restful_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> insertProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.insert(product),HttpStatus.CREATED);
    }

    @PutMapping("/{proId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("proId")Integer proId, @RequestBody Product product){
        return new ResponseEntity<>(productService.update(proId, product),HttpStatus.OK);
    }

    @DeleteMapping("/{proId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("proId")Integer proId){
        return new ResponseEntity<>(productService.delete(proId),HttpStatus.NO_CONTENT);
    }
}
