package com.konradlesiak.service;

import com.konradlesiak.domain.Recipe;
import com.konradlesiak.dto.RecipeDto;
import com.konradlesiak.mapper.RecipeMapper;
import com.konradlesiak.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
class RecipeServiceImplIT {

    public static final String NEW_DESCRIPTION = "New description";

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeMapper recipeMapper;

    @BeforeEach

    void setUp() {
    }

    @Test
    @Transactional
    void save() {
        // given
        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe recipe = recipes.iterator().next();
        RecipeDto recipeDto = recipeMapper.toDto(recipe);

        // when
        recipeDto.setDescription(NEW_DESCRIPTION);
        RecipeDto savedRecipeDto = recipeService.save(recipeDto);

        // then
        assertEquals(NEW_DESCRIPTION, savedRecipeDto.getDescription());
        assertEquals(recipe.getId(), savedRecipeDto.getId());
        assertEquals(recipe.getCategories().size(), savedRecipeDto.getCategories().size());
        assertEquals(recipe.getIngredients().size(), savedRecipeDto.getIngredients().size());
    }
}