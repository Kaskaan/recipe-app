package com.konradlesiak.dto;

import com.konradlesiak.domain.Recipe;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotesDto {

    private Long id;
    private Recipe recipe;
    private String recipeNotes;
}
