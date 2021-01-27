package com.konradlesiak.service;

import com.konradlesiak.domain.Recipe;
import com.konradlesiak.dto.RecipeDto;
import com.konradlesiak.mapper.RecipeMapper;
import com.konradlesiak.repository.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
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
    public Set<RecipeDto> findAll() {
        Set<RecipeDto> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(r -> recipes.add(recipeMapper.toDto(r)));
        return recipes;
    }

    @Override
    public RecipeDto findById(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElse(null);

        if (recipe == null) {
            System.out.println("Recipe with ID: " + id + " not found");
        } else {
            System.out.println("Recipe found! Recipe ID: " + id);
        }

        return recipeMapper.toDto(recipe);
    }

    @Override
    @Transactional
    public RecipeDto save(RecipeDto recipeDto) {
        Recipe recipe = recipeMapper.toEntity(recipeDto);
        Recipe savedRecipe = recipeRepository.save(recipe);
        System.out.println("Recipe saved. Recipe ID: " + savedRecipe.getId());
        return recipeMapper.toDto(savedRecipe);
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }
}
