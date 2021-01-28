package com.konradlesiak.service;

import com.konradlesiak.domain.Ingredient;
import com.konradlesiak.domain.Recipe;
import com.konradlesiak.dto.IngredientDto;
import com.konradlesiak.mapper.IngredientMapper;
import com.konradlesiak.repository.IngredientRepository;
import com.konradlesiak.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class IngredientServiceImpl implements IngredientService {
    
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

    public IngredientServiceImpl(RecipeRepository recipeRepository, IngredientRepository ingredientRepository, 
                                 IngredientMapper ingredientMapper) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.ingredientMapper = ingredientMapper;
    }

    @Override
    public Set<IngredientDto> findAll() {
        Set<IngredientDto> ingredientsDto = new HashSet<>();
        ingredientRepository.findAll().forEach(ingredientMapper::toDto);
        return ingredientsDto;
    }

    @Override
    public IngredientDto findById(Long id) {
        Ingredient ingredientDto = ingredientRepository.findById(id).orElse(null);
        return ingredientMapper.toDto(ingredientDto);
    }

    @Override
    public IngredientDto findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (recipeOptional.isEmpty()) {
            System.out.println("IngredientServiceImpl: Recipe with ID: " + recipeId + " Not Found!");
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientDto> ingredientDto = recipe.getIngredients().stream()
                .filter(i -> i.getId().equals(ingredientId))
                .map(ingredientMapper::toDto)
                .findFirst();

        if (ingredientDto.isEmpty()) {
            System.out.println("IngredientServiceImpl: Ingredient with ID: " + ingredientId + " Not Found!");
        }
        return ingredientDto.get();
    }

    @Override
    public void deleteById(Long id) {
        ingredientRepository.deleteById(id);
    }
}
