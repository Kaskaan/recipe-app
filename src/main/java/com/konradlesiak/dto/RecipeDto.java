package com.konradlesiak.dto;

import com.konradlesiak.domain.Category;
import com.konradlesiak.domain.Difficulty;
import com.konradlesiak.domain.Ingredient;
import com.konradlesiak.domain.Notes;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class RecipeDto {

    private Long id;
    private String description;
    private int prepTime;
    private int cookTime;
    private int servings;
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;
    private Byte[] image;
    private Notes notes;
    private Set<Ingredient> ingredients = new HashSet<>();
    private Set<Category> categories = new HashSet<>();
}
