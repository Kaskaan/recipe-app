package com.konradlesiak.controller;

import com.konradlesiak.dto.CategoryDto;
import com.konradlesiak.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("categories")
    public String getCategories(Model model) {
        final Set<CategoryDto> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }
}
