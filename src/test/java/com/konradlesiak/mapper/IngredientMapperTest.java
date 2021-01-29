package com.konradlesiak.mapper;

import com.konradlesiak.domain.Ingredient;
import com.konradlesiak.domain.Recipe;
import com.konradlesiak.domain.UnitOfMeasure;
import com.konradlesiak.dto.IngredientDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IngredientMapperTest {

    IngredientMapper mapper = IngredientMapper.INSTANCE;

    @Test
    void testToDtoNull() {
        assertNull(mapper.toDto(null));
    }

    @Test
    void testToEntityNull() {
        assertNull(mapper.toEntity(null));
    }

    @Test
    void testToDtoNotEmptyObject() {
        Ingredient entity = new Ingredient();
        entity.setId(1L);
        assertNotNull(mapper.toDto(entity));
    }

    @Test
    void testToEntityNotEmptyObject() {
        IngredientDto dto = new IngredientDto();
        dto.setId(1L);
        assertNotNull(mapper.toEntity(dto));
    }

    @Test
    void toDto() {
        UnitOfMeasure unitOfMeasureEntity = new UnitOfMeasure();
        unitOfMeasureEntity.setId(1L);

        Recipe recipeEntity = new Recipe();
        recipeEntity.setId(1L);

        Ingredient entity = new Ingredient();
        entity.setId(1L);
        entity.setAmount(new BigDecimal(2));
        entity.setDescription("description");
        entity.setRecipe(recipeEntity);
        entity.setUnitOfMeasure(unitOfMeasureEntity);

        IngredientDto dto = mapper.toDto(entity);

        assertNotNull(dto);
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getAmount(), dto.getAmount());
        assertEquals(entity.getDescription(), dto.getDescription());
        assertEquals(entity.getRecipe().getId(), dto.getRecipe().getId());
        assertEquals(entity.getUnitOfMeasure().getId(), dto.getUnitOfMeasure().getId());
    }

    @Test
    void toEntity() {
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(1L);

        Recipe recipe = new Recipe();
        recipe.setId(1L);

        IngredientDto dto = new IngredientDto();
        dto.setId(1L);
        dto.setAmount(new BigDecimal(2));
        dto.setDescription("description");
        dto.setRecipe(recipe);
        dto.setUnitOfMeasure(unitOfMeasure);

        Ingredient entity = mapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getAmount(), entity.getAmount());
        assertEquals(dto.getDescription(), entity.getDescription());
        assertEquals(dto.getRecipe().getId(), entity.getRecipe().getId());
        assertEquals(dto.getUnitOfMeasure().getId(), entity.getUnitOfMeasure().getId());
    }
}