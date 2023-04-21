package com.example.springcommerce.security.controller;

import javax.validation.Valid;

import com.example.springcommerce.model.User;
import com.example.springcommerce.repository.UserRepository;
import com.example.springcommerce.security.service.AuthService;
import org.apache.tomcat.util.http.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private AuthService service;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User dto) {
        if(service.login(dto) == null){
            System.out.println("============================");
            return ResponseEntity.status(HttpStatus.valueOf(500))
                    .body(null);
        }
        return ResponseEntity.status(HttpStatus.valueOf(200))
                .body(service.login(dto));
    }

    @PostMapping("signup")
    public Object signUp(@RequestBody User dto) {
        if(userRepository.findUserByUsername(dto.getUsername()).isPresent()){
            return new ResponseEntity<>(null, HttpStatus.valueOf(500));
        }
        return new ResponseEntity<>(service.signUp(dto), HttpStatus.OK);
    }
}