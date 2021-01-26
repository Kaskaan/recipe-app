package com.konradlesiak.dto;

import com.konradlesiak.domain.Recipe;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Long id;
    private String description;
    private Set<Recipe> recipes;
}
