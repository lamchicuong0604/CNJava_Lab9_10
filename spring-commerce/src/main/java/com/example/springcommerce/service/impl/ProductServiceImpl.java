package com.example.springcommerce.service.impl;

import com.example.springcommerce.dto.ProductSearchRequest;
import com.example.springcommerce.model.Cart;
import com.example.springcommerce.model.Product;
import com.example.springcommerce.model.User;
import com.example.springcommerce.repository.CartRepository;
import com.example.springcommerce.repository.ProductRepository;
import com.example.springcommerce.repository.UserRepository;
import com.example.springcommerce.service.ProductSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductSerivce {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Product> findALlProduct(ProductSearchRequest request) {
        return productRepository.search(request);
    }

    @Override
    public Cart addToCart(Integer productId, String username) {

        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()) {
            return null;
        }
        User user = userRepository.findUserByUsername(username).get();

        Product currenProduct = product.get();
        Cart cart = new Cart();
        cart.setProductId(productId);
        cart.setProductCost(currenProduct.getPrice());
        cart.setProductName(currenProduct.getName());
        cart.setUserId(user.getId());
        cart.setOrdered(Boolean.FALSE);
        cartRepository.save(cart);

        return cart;
    }

    @Override
    public List<Cart> findCartByUser(String username) {
        User user = userRepository.findUserByUsername(username).get();
        List<Cart> carts = cartRepository.findCartsByUserId(user.getId());
        carts = carts.stream().filter(t -> t.getOrdered().equals(Boolean.FALSE)).collect(Collectors.toList());
        return carts;
    }

    @Override
    public Product create(Product product) {
        Product productCreate = new Product();
        productCreate.setName(product.getName());
        productCreate.setBrand(product.getBrand());
        productCreate.setColor(product.getColor());
        productCreate.setPrice(product.getPrice());
        productCreate.setCategoryId(product.getCategoryId());
        return productRepository.save(product);
    }

    @Override
    public Product update(Integer id, Product dto) {
        Product product = productRepository.findById(id).get();
        product.setName(dto.getName());
        product.setBrand(dto.getBrand());
        product.setColor(dto.getColor());
        product.setPrice(dto.getPrice());
        product.setCategoryId(dto.getCategoryId());

        return productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }
}
