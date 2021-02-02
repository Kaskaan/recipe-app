package com.konradlesiak.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotesDto {

    private Long id;
    private RecipeDto recipe;
    private String recipeNotes;
}
