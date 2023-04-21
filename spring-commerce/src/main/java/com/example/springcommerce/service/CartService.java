package com.example.springcommerce.service;

import com.example.springcommerce.model.Cart;

import java.util.List;

public interface CartService {
    List<Cart> orderCart(String username);

    void deleteProduct(Integer id);
}
