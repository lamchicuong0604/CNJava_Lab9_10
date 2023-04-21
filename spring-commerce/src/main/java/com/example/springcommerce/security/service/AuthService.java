package com.example.springcommerce.security.service;

import com.example.springcommerce.model.User;
public interface AuthService {
    User signUp(User user);
    User login(User user);
}
