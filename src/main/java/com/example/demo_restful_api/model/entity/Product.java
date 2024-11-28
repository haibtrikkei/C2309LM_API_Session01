package com.example.demo_restful_api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer proId;
    @Column(name = "product_name",length = 100)
    private String proName;
    @Column(name = "producer",length = 100)
    private String producer;
    @Column(name = "year_making")
    private Integer yearMaking;
    @Column(name = "epxire_date")
    private Date expireDate;
    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "cate_id",referencedColumnName = "cate_id")
//    @JsonIgnore
    private Category category;
}
