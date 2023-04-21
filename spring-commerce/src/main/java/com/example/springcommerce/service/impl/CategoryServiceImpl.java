package com.example.springcommerce.service.impl;

import com.example.springcommerce.model.Category;
import com.example.springcommerce.repository.CategoryRepository;
import com.example.springcommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
