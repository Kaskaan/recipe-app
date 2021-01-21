package com.konradlesiak.controller;

import com.konradlesiak.domain.Recipe;
import com.konradlesiak.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({"", "/", "index", "index.html"})
    public String getHomePage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());

        log.debug("### Loading index page. ###");
        return "index";
    }

    @GetMapping({"/recipe/{id}"})
    public String getRecipe(Model model, @PathVariable Long id) {
        final Optional<Recipe> recipeById = recipeService.getRecipeById(id);

        if (recipeById.isEmpty()) {
            log.debug("### Recipe not found. ###");
            return "redirect:/index";
        } else {
            model.addAttribute("recipe", recipeById);
            log.debug("### Loading recipe page. ###");
            return "recipe";
        }
    }
}
