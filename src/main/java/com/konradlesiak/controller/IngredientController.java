package com.konradlesiak.controller;

import com.konradlesiak.dto.IngredientDto;
import com.konradlesiak.dto.RecipeDto;
import com.konradlesiak.mapper.IngredientMapper;
import com.konradlesiak.mapper.RecipeMapper;
import com.konradlesiak.service.IngredientService;
import com.konradlesiak.service.RecipeService;
import com.konradlesiak.service.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Slf4j
@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;
    private final RecipeMapper recipeMapper;
    private final IngredientMapper ingredientMapper;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService,
                                UnitOfMeasureService unitOfMeasureService, RecipeMapper recipeMapper,
                                IngredientMapper ingredientMapper) {

        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
        this.recipeMapper = recipeMapper;
        this.ingredientMapper = ingredientMapper;
    }

    @GetMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable Long recipeId, Model model){
        log.debug("Getting ingredient list for recipe id: " + recipeId);
        RecipeDto recipes = recipeService.findById(recipeId);
        Set<IngredientDto> ingredients = recipes.getIngredients();

        model.addAttribute("recipe", recipes);
        model.addAttribute("ingredients", ingredients);

        return "recipe/ingredients/ingredients";
    }

    @GetMapping("recipe/{recipeId}/ingredient/{ingredientId}")
    public String getIngredient(@PathVariable Long recipeId, @PathVariable Long ingredientId, Model model) {
        IngredientDto ingredientDto = ingredientService.findByRecipeIdAndIngredientId(recipeId, ingredientId);

        model.addAttribute("ingredient", ingredientDto);
        model.addAttribute("uom", unitOfMeasureService.findById(ingredientDto.getUnitOfMeasureId()));

        return "/recipe/ingredients/ingredient";
    }

    @GetMapping("recipe/{recipeId}/ingredient/new")
    public String createRecipeIngredient(@PathVariable Long recipeId, Model model) {
        RecipeDto recipeServiceById = recipeService.findById(recipeId);
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setRecipeId(recipeId);

        recipeServiceById.getIngredients().add(ingredientDto);
        RecipeDto savedRecipe = recipeService.save(recipeServiceById);

        model.addAttribute("ingredient", ingredientDto);
        model.addAttribute("recipe", savedRecipe);
        model.addAttribute("uomList", unitOfMeasureService.findAll());

        return "recipe/ingredients/ingredientform";
    }

    @GetMapping("recipe/{recipeId}/ingredient/{ingredientId}/update")
    public String updateRecipeIngredient(@PathVariable Long recipeId,
                                         @PathVariable Long ingredientId, Model model) {
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(recipeId, ingredientId));
        model.addAttribute("uomList", unitOfMeasureService.findAll());

        return "recipe/ingredients/ingredientform";
    }

    @PostMapping("recipe/{recipeId}/ingredient")
    public String saveOrUpdateRecipeIngredient(@PathVariable Long recipeId, @ModelAttribute IngredientDto ingredientDto) {
        IngredientDto savedIngredient = ingredientService.save(recipeId, ingredientDto);

        return "redirect:/recipe/" + recipeId + "/ingredient/" + savedIngredient.getId();
    }

    @DeleteMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{ingredientId}/delete")
    public String deleteIngredient(@PathVariable Long recipeId, @PathVariable Long ingredientId) {
        ingredientService.deleteById(ingredientId);
        return "redirect:/recipe/" + recipeId + "/ingredients";
    }
}
