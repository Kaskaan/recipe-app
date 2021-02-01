package com.konradlesiak.controller;

import com.konradlesiak.dto.RecipeDto;
import com.konradlesiak.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("recipe/{id}")
    public String getRecipeById(Model model, @PathVariable Long id) {
        final RecipeDto recipeById = recipeService.findById(id);

        if (recipeById == null) {
            log.debug("### Recipe not found. ###");
            return "redirect:/index.html";
        } else {
            model.addAttribute("recipe", recipeById);
            log.debug("### Loading recipe page. ###");
            return "recipe";
        }
    }

    @GetMapping("recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeDto());

        return "recipe/recipeform";
    }

    @GetMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable Long id, Model model) {
        model.addAttribute("recipe", recipeService.findById(id));

        return "recipe/recipeform";
    }

    @PostMapping("recipe")
    public String saveOrUpdateRecipe(@ModelAttribute RecipeDto recipeDto) {
        RecipeDto savedRecipeDto = recipeService.save(recipeDto);

        return "redirect:/recipe/" + savedRecipeDto.getId();
    }

    @DeleteMapping("recipe/{id}/delete")
    public String deleteRecipe(@PathVariable Long id) {
        recipeService.deleteById(id);

        return "redirect:/index.html";
    }

}
