package com.konradlesiak.dto;

import com.konradlesiak.domain.Difficulty;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @EqualsAndHashCode.Exclude
    private NotesDto notes;
    @EqualsAndHashCode.Exclude
    private Set<IngredientDto> ingredients = new HashSet<>();
    @EqualsAndHashCode.Exclude
    private Set<CategoryDto> categories = new HashSet<>();
}
