package com.example.springcommerce.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "name")
    private String productName;

    @Column(name = "cost")
    private Double productCost;

    @Column(name = "ordered")
    private Boolean ordered;
}
