package com.konradlesiak.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDto {

    private Long id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureDto unitOfMeasure;
    private RecipeDto recipe;
}
