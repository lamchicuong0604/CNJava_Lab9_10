package com.example.springcommerce.controller;

import com.example.springcommerce.dto.ProductSearchRequest;
import com.example.springcommerce.model.Product;
import com.example.springcommerce.repository.ProductRepository;
import com.example.springcommerce.service.ProductSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    private ProductSerivce productSerivce;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/search")
    public Object getAllProduct(@RequestBody ProductSearchRequest request) {
        return productSerivce.findALlProduct(request);
    }

    @GetMapping("/all")
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @GetMapping("/findById")
    public Product findById(@RequestParam("id") Integer id) {
        return productRepository.findById(id).get();
    }


    @GetMapping("/{id}/carts/{username}")
    public Object addProductToCart(@PathVariable Integer id, @PathVariable String username) {
        return productSerivce.addToCart(id, username);
    }

    @GetMapping("/carts/{username}")
    public Object showCart(@PathVariable String username) {
        return productSerivce.findCartByUser(username);
    }

    @PostMapping
    public Object create(@RequestBody Product product) {
        return productSerivce.create(product);
    }

    @PostMapping("{id}")
    public Object update(@PathVariable Integer id, @RequestBody Product dto) {
        return productSerivce.update(id, dto);
    }

    @DeleteMapping("{id}")
    public void update(@PathVariable Integer id) {
        productSerivce.delete(id);
    }
}
