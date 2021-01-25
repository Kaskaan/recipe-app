package com.konradlesiak.dto;

import com.konradlesiak.domain.Recipe;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CategoryDto {

    private Long id;
    private String description;
    private Set<Recipe> recipes;
}
