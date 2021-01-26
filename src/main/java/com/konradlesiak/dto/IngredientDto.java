package com.konradlesiak.dto;

import com.konradlesiak.domain.Recipe;
import com.konradlesiak.domain.UnitOfMeasure;
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
    private UnitOfMeasure unitOfMeasure;
    private Recipe recipe;
}
