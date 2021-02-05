package com.konradlesiak.mapper;

import com.konradlesiak.domain.Ingredient;
import com.konradlesiak.dto.IngredientDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IngredientMapper {

    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);

    @Mapping(source = "recipe.id", target = "recipeId")
    @Mapping(source = "unitOfMeasure.id", target = "unitOfMeasureId")
    IngredientDto toDto(Ingredient ingredient);

    @InheritInverseConfiguration
    Ingredient toEntity(IngredientDto ingredientDto);
}
