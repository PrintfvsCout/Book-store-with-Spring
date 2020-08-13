package com.example.EMTProdKniga.controller;

import com.example.EMTProdKniga.model.Category;
import com.example.EMTProdKniga.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cats")
public class CategoryController
{
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService)
    {
        Category  fiction = new Category(1,"Fiction","Fiction books");
        Category  kids = new Category(2,"Kids books","Books for kids");
        Category  novel= new Category(3,"Novels","Short books");
        this.categoryService = categoryService;
        categoryService.addCategory(fiction);
        categoryService.addCategory(kids);
        categoryService.addCategory(novel);
    }

    @GetMapping("/render")
    public String addCategory(Model model)
    {
        model.addAttribute("cate", new Category());
        return "add-product";
    }


    @GetMapping("/sendToServer")
    public String saveCat(Model model,Category category)
    {
        model.addAttribute("cate", new Category() );
        categoryService.addCategory(category);
        return "redirect:/cats";
    }


    @GetMapping
    public String getCategories(Model model)
    {
         List<Category> categories= categoryService.getCategories();
         model.addAttribute("categories",categories);
         return "products";
    }



}
