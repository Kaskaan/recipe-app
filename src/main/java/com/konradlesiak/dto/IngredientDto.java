package com.konradlesiak.dto;

import com.konradlesiak.domain.Recipe;
import com.konradlesiak.domain.UnitOfMeasure;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class IngredientDto {

    private Long id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasure unitOfMeasure;
    private Recipe recipe;
}
