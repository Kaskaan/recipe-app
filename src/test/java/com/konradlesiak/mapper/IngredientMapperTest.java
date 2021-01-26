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
        Ingredient entity = new Ingredient();
        entity.setId(1L);
        entity.setAmount(new BigDecimal(2));
        entity.setDescription("description");
        entity.setRecipe(new Recipe());
        entity.setUnitOfMeasure(new UnitOfMeasure());

        IngredientDto dto = mapper.toDto(entity);

        assertNotNull(dto);
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getAmount(), dto.getAmount());
        assertEquals(entity.getDescription(), dto.getDescription());
        assertEquals(entity.getRecipe(), dto.getRecipe());
        assertEquals(entity.getUnitOfMeasure(), dto.getUnitOfMeasure());
    }

    @Test
    void toEntity() {
        IngredientDto dto = new IngredientDto();
        dto.setId(1L);
        dto.setAmount(new BigDecimal(2));
        dto.setDescription("description");
        dto.setRecipe(new Recipe());
        dto.setUnitOfMeasure(new UnitOfMeasure());

        final Ingredient entity = mapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getAmount(), entity.getAmount());
        assertEquals(dto.getDescription(), entity.getDescription());
        assertEquals(dto.getRecipe(), entity.getRecipe());
        assertEquals(dto.getUnitOfMeasure(), entity.getUnitOfMeasure());
    }
}