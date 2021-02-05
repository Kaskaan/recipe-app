package com.konradlesiak.service;

import com.konradlesiak.dto.IngredientDto;

import java.util.Set;

public interface IngredientService {

    Set<IngredientDto> findAll();
    IngredientDto findById(Long id);
    IngredientDto findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
    IngredientDto save(Long id, IngredientDto ingredientDto);
    void deleteById(Long id);
}
