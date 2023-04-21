package com.example.springcommerce.security.service;
import java.util.Optional;

import com.example.springcommerce.model.User;
import com.example.springcommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User login(User dto) {
        //get user info
        Optional<User> userOpt = repository.findUserByUsername(dto.getUsername());

        String encodedPassword = userOpt.get().getPassword();
        if ("ADMIN".equals(userOpt.get().getRole())) {
            return userOpt.get();
        } else {
            if(passwordEncoder.matches(dto.getPassword(), encodedPassword)) {
                return userOpt.get();
            } else {
                return null;
            }
        }
    }

    @Override
    public User signUp(User user) {
        Optional<User> userOpt = repository.findUserByUsername(user.getUsername());
        if (userOpt.isPresent()) {
            return null;
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole("USER");
            repository.save(user);
            return user;
        }
    }
}