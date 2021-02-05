package com.konradlesiak.mapper;

import com.konradlesiak.domain.Recipe;
import com.konradlesiak.dto.RecipeDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipeMapper {

    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    Recipe toEntity(RecipeDto recipeDto);

    RecipeDto toDto(Recipe recipe);
}
