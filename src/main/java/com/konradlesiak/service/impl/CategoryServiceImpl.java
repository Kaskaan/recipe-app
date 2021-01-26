package com.konradlesiak.service.impl;

import com.konradlesiak.domain.Category;
import com.konradlesiak.dto.CategoryDto;
import com.konradlesiak.mapper.CategoryMapper;
import com.konradlesiak.repository.CategoryRepository;
import com.konradlesiak.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryDto getByDescription(String description) {
        return categoryMapper.toDto(categoryRepository.findByDescription(description).orElse(null));
    }

    public Set<CategoryDto> getCategories() {
        Set<CategoryDto> categoryDtoSet = new HashSet<>();
        categoryRepository.findAll().forEach(c -> categoryDtoSet.add(categoryMapper.toDto(c)));
        return categoryDtoSet;
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    public CategoryDto save(CategoryDto categoryDto) {
        if (categoryDto != null) {
            final Category categoryEntity = categoryMapper.toEntity(categoryDto);
            categoryRepository.save(categoryEntity);
            return categoryDto;
        } else {
            System.out.println("Cannot save! CategoryDTO is null!");
            return null;
        }
    }
}
