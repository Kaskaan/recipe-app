package com.konradlesiak.service;

import com.konradlesiak.domain.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Optional<Recipe> getRecipeById(Long id);
}
