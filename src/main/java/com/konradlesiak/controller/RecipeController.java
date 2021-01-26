package com.konradlesiak.controller;

import com.konradlesiak.dto.RecipeDto;
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

    @GetMapping({"/recipe/{id}"})
    public String getRecipeById(Model model, @PathVariable Long id) {
        final Optional<RecipeDto> recipeById = recipeService.getRecipeById(id);

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
