package com.example.springcommerce.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.springcommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService  {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        Optional<com.example.springcommerce.model.User> userOpt = repository.findUserByUsername(username);
        if(userOpt.isEmpty())
            return null;
        com.example.springcommerce.model.User currentUser = userOpt.get();

        return new User(currentUser.getUsername(), currentUser.getPassword(), grantedAuthorities);

    }
}