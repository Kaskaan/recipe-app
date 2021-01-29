package com.konradlesiak.service;

import com.konradlesiak.domain.Ingredient;
import com.konradlesiak.domain.Recipe;
import com.konradlesiak.dto.IngredientDto;
import com.konradlesiak.mapper.IngredientMapper;
import com.konradlesiak.repository.IngredientRepository;
import com.konradlesiak.repository.RecipeRepository;
import com.konradlesiak.repository.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IngredientServiceImpl(RecipeRepository recipeRepository, IngredientRepository ingredientRepository,
                                 IngredientMapper ingredientMapper, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.ingredientMapper = ingredientMapper;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
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
    @Transactional
    public IngredientDto save(IngredientDto ingredientDto) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(ingredientDto.getRecipe().getId());

        if (recipeOptional.isEmpty()) {

            //todo toss error if not found!
            return new IngredientDto();
        } else {
            Recipe recipe = recipeOptional.get();

            Optional<Ingredient> ingredientOptional = recipe
                    .getIngredients()
                    .stream()
                    .filter(ingredient -> ingredient.getId().equals(ingredientDto.getId()))
                    .findFirst();

            if (ingredientOptional.isPresent()) {
                Ingredient ingredientFound = ingredientOptional.get();
                ingredientFound.setDescription(ingredientDto.getDescription());
                ingredientFound.setAmount(ingredientDto.getAmount());
                ingredientFound.setUnitOfMeasure(unitOfMeasureRepository
                        .findById(ingredientDto.getUnitOfMeasure().getId())
                        .orElseThrow(() -> new RuntimeException("UOM NOT FOUND"))); //todo address this
            } else {
                //add new Ingredient
                Ingredient ingredient = ingredientMapper.toEntity(ingredientDto);
                ingredient.setRecipe(recipe);

                recipe.addIngredient(ingredient);
            }

            Recipe savedRecipe = recipeRepository.save(recipe);

            Optional<Ingredient> savedIngredientOptional = savedRecipe.getIngredients().stream()
                    .filter(recipeIngredients -> recipeIngredients.getId().equals(ingredientDto.getId()))
                    .findFirst();

            // todo check for fail
            if (savedIngredientOptional.isEmpty()) {
                savedIngredientOptional = savedRecipe.getIngredients().stream()
                        .filter(i -> i.getDescription().equals(ingredientDto.getDescription()))
                        .filter(i -> i.getAmount().equals(ingredientDto.getAmount()))
                        .filter(i -> i.getUnitOfMeasure().getId().equals(ingredientDto.getUnitOfMeasure().getId()))
                        .findFirst();
            }
            return ingredientMapper.toDto(savedIngredientOptional.get());
        }
    }

    @Override
    public void deleteById(Long id) {
        Optional<Ingredient> ingredientOptional = ingredientRepository.findById(id);

        if (ingredientOptional.isEmpty()) {
            System.out.println("No possibility to delete ingredient with ID: " + ingredientOptional.get().getId() + " because doesn't exist!");
        } else {
            ingredientRepository.deleteById(id);
            System.out.println("Ingredient with ID: " + id + " has been deleted!");
        }
    }
}
