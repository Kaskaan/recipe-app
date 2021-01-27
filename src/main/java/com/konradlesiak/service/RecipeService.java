package com.konradlesiak.service;

import com.konradlesiak.dto.RecipeDto;

import java.util.Set;

public interface RecipeService {

    Set<RecipeDto> findAll();
    RecipeDto findById(Long id);
    RecipeDto save(RecipeDto recipeDto);
    void deleteById(Long id);
}
