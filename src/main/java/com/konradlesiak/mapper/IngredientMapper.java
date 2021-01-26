package com.konradlesiak.mapper;

import com.konradlesiak.domain.Ingredient;
import com.konradlesiak.dto.IngredientDto;
import org.mapstruct.Mapper;

@Mapper
public interface IngredientMapper {

    IngredientDto toDto(Ingredient ingredient);
    Ingredient toEntity(IngredientDto ingredientDto);
}
