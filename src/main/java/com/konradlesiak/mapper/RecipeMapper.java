package com.konradlesiak.mapper;

import com.konradlesiak.domain.Recipe;
import com.konradlesiak.dto.RecipeDto;
import org.mapstruct.Mapper;

@Mapper
public interface RecipeMapper {

    RecipeDto toDto(Recipe recipe);
    Recipe toEntity(RecipeDto recipeDto);
}
