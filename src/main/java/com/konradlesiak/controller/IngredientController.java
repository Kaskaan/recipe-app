package com.konradlesiak.controller;

import com.konradlesiak.dto.IngredientDto;
import com.konradlesiak.service.IngredientService;
import com.konradlesiak.service.RecipeService;
import com.konradlesiak.service.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService,
                                UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
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

    @GetMapping("/recipe/{recipeId}/ingredient/{ingredientId}/update")
    public String updateRecipeIngredient(@PathVariable Long recipeId,
                                         @PathVariable Long ingredientId, Model model) {
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(recipeId, ingredientId));
        model.addAttribute("uomList", unitOfMeasureService.findAll());

        return "recipe/ingredients/ingredientform";
    }

    @PostMapping
    @RequestMapping("/recipe/{recipeId}/ingredient")
    public String saveOrUpdateRecipeIngredient(@PathVariable Long recipeId, @ModelAttribute IngredientDto ingredientDto) {
        IngredientDto savedIngredient = ingredientService.save(recipeId, ingredientDto);

        return "redirect:/recipe/" + savedIngredient.getRecipe().getId() + "/ingredient/" + savedIngredient.getId();
    }
}
