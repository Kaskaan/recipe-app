package com.konradlesiak.service;

import com.konradlesiak.dto.RecipeDto;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {

    Set<RecipeDto> getRecipes();
    Optional<RecipeDto> getRecipeById(Long id);
    RecipeDto save(RecipeDto recipeDto);
}
