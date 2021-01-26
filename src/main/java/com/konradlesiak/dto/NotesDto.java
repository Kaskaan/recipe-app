package com.konradlesiak.dto;

import com.konradlesiak.domain.Recipe;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotesDto {

    private Long id;
    private Recipe recipe;
    private String recipeNotes;
}
