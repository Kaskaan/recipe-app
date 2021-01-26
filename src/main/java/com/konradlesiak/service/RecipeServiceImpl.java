package com.konradlesiak.service;

import com.konradlesiak.domain.Recipe;
import com.konradlesiak.dto.RecipeDto;
import com.konradlesiak.mapper.RecipeMapper;
import com.konradlesiak.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = RecipeMapper.INSTANCE;
    }

    @Override
    public Set<RecipeDto> getRecipes() {
        Set<RecipeDto> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(r -> recipes.add(recipeMapper.toDto(r)));
        return recipes;
    }

    @Override
    public Optional<RecipeDto> getRecipeById(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElse(null);
        return Optional.of(recipeMapper.toDto(recipe));
    }

    @Override
    public RecipeDto save(RecipeDto recipeDto) {
        Recipe recipe = recipeMapper.toEntity(recipeDto);
        Recipe savedRecipe = recipeRepository.save(recipe);
        return recipeMapper.toDto(savedRecipe);
    }
}
