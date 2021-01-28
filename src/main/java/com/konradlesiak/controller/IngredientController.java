package com.konradlesiak.controller;

import com.konradlesiak.dto.IngredientDto;
import com.konradlesiak.service.IngredientService;
import com.konradlesiak.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @GetMapping("/recipe/{recipeId}/ingredients")
    public String getListOfIngredients(@PathVariable Long recipeId, Model model) {
        model.addAttribute("recipe", recipeService.findById(recipeId));
        return "recipe/ingredients/ingredients";
    }

    @GetMapping("/recipe/{recipeId}/ingredient/{ingredientId}")
    public String getIngredients(@PathVariable Long recipeId, @PathVariable Long ingredientId, Model model) {
        IngredientDto ingredientDto = ingredientService.findByRecipeIdAndIngredientId(recipeId, ingredientId);
        model.addAttribute("ingredient", ingredientDto);
        return "/recipe/ingredients/ingredient";
    }

//    @DeleteMapping
//    @RequestMapping("/recipe/{recipeId}/ingredient/{ingredientId}/delete")
//    @Transactional
//    public String deleteIngredientById(@PathVariable Long recipeId, @PathVariable Long ingredientId) {
//        Set<Ingredient> ingredientSet = recipeService.findById(recipeId).getIngredients();
//        Optional<Ingredient> ingredient = ingredientSet.stream().filter(i -> i.getId().equals(ingredientId)).findFirst();
//        if (ingredient.isEmpty()) {
//            System.out.println("No ingredient with ID: " + ingredientId);
//        } else {
//            ingredientSet.remove(ingredient.get());
//        }
//
//        return "redirect:/recipe/" + recipeId + "/ingredients";
//    }
}
