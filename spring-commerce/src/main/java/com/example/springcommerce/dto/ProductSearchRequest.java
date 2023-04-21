package com.example.springcommerce.dto;

import lombok.Data;

@Data
public class ProductSearchRequest {

    private String name;

    private Double fromPrice;

    private Double toPrice;

    private String brand;

    private String color;

    private Integer categoryId;
}
