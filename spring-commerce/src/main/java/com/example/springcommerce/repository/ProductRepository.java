package com.example.springcommerce.repository;

import com.example.springcommerce.model.Product;
import com.example.springcommerce.repository.custom.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, ProductRepositoryCustom {

}
