package com.example.EMTProdKniga.service;

import com.example.EMTProdKniga.model.Category;
import com.example.EMTProdKniga.repo.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService
{
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories()
    {
        return  categoryRepository.findAll();
    }

    public Optional<Category> getCategory(Long id)
    {
        return categoryRepository.findById(id);
    }

    public void addCategory(Category category)
    {
        categoryRepository.save(category);
    }

}
