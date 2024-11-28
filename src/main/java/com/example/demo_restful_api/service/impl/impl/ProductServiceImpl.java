package com.example.demo_restful_api.service.impl.impl;

import com.example.demo_restful_api.model.entity.Product;
import com.example.demo_restful_api.repository.ProductRepository;
import com.example.demo_restful_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product insert(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Integer proId, Product product) {
        productRepository.findById(proId).orElseThrow(()-> new NoSuchElementException("Khong ton tai product co id: "+proId));
        product.setProId(proId);
        return productRepository.save(product);
    }

    @Override
    public Product delete(Integer proId) {
        Product product = productRepository.findById(proId).orElseThrow(() -> new NoSuchElementException("Khong ton tai product co id: " + proId));
        productRepository.delete(product);
        return product;
    }
}
