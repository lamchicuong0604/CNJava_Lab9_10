package com.example.springcommerce.repository.custom;

import com.example.springcommerce.dto.ProductSearchRequest;
import com.example.springcommerce.model.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> search(ProductSearchRequest searchQuery);
}
