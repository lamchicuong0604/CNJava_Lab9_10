package com.example.springcommerce.service;

import com.example.springcommerce.dto.ProductSearchRequest;
import com.example.springcommerce.model.Cart;
import com.example.springcommerce.model.Product;

import java.util.List;

public interface ProductSerivce {
    List<Product> findALlProduct(ProductSearchRequest request);

    Cart addToCart(Integer productId, String username);

    List<Cart> findCartByUser(String username);

    Product create(Product product);

    Product update(Integer id, Product dto);

    void delete(Integer id);
}
