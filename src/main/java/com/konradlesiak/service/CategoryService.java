package com.konradlesiak.service;

import com.konradlesiak.dto.CategoryDto;

import java.util.Set;

public interface CategoryService {

    CategoryDto getByDescription(String description);
    Set<CategoryDto> getCategories();
    void deleteById(Long id);
    CategoryDto save(CategoryDto categoryDto);

}
