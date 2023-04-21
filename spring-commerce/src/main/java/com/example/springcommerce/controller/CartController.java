package com.example.springcommerce.controller;

import com.example.springcommerce.model.Cart;
import com.example.springcommerce.model.User;
import com.example.springcommerce.repository.CartRepository;
import com.example.springcommerce.repository.UserRepository;
import com.example.springcommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @GetMapping("order/{username}")
    public Object order(@PathVariable String username) {
        return cartService.orderCart(username);
    }

    @PostMapping("/add")
    public void addCart(@RequestBody Cart cart, @RequestParam("username") String username){
        User user = userRepository.findUserByUsername(username).get();
        cart.setUserId(user.getId());
        cartRepository.save(cart);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        cartService.deleteProduct(id);
    }
}
