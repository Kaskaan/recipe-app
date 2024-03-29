package com.konradlesiak.mapper;

import com.konradlesiak.domain.Recipe;
import com.konradlesiak.dto.RecipeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipeMapper {

    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    RecipeDto toDto(Recipe recipe);
    Recipe toEntity(RecipeDto recipeDto);
}
