package com.example.demo_restful_api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @Column(name = "cate_id")
    private String cateId;
    @Column(name = "cate_name",nullable = false,unique = true,length = 100)
    private String cateName;
    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy ="category")
    @JsonIgnore
    private List<Product> products;
}
