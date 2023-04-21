package com.example.springcommerce.service.impl;

import com.example.springcommerce.model.Cart;
import com.example.springcommerce.model.User;
import com.example.springcommerce.repository.CartRepository;
import com.example.springcommerce.repository.ProductRepository;
import com.example.springcommerce.repository.UserRepository;
import com.example.springcommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> orderCart(String username) {
        User user = userRepository.findUserByUsername(username).get();
        List<Cart> carts = cartRepository.findCartsByUserId(user.getId());
        for (Cart cart:
             carts) {
            cart.setOrdered(Boolean.TRUE);
            cartRepository.save(cart);
        }
        return carts;
    }

    @Override
    public void deleteProduct(Integer id) {
        Cart cart = cartRepository.getById(id);
        cartRepository.delete(cart);
    }
}