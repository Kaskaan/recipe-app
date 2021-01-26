package com.konradlesiak.mapper;

import com.konradlesiak.domain.Category;
import com.konradlesiak.domain.Recipe;
import com.konradlesiak.dto.CategoryDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapperTest {

    final CategoryMapper mapper = CategoryMapper.INSTANCE;
    Set<Recipe> recipes;

    @BeforeEach
    void setUp() {
        recipes = new HashSet<>();
        recipes.add(new Recipe());
    }

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
        assertNotNull(mapper.toDto(new Category()));
    }

    @Test
    void testToEntityNotEmptyObject() {
        assertNotNull(mapper.toEntity(new CategoryDto()));
    }

    @Test
    void toDto() {
        Category entity = new Category();
        entity.setId(1L);
        entity.setDescription("description");
        entity.setRecipes(recipes);

        CategoryDto dto = mapper.toDto(entity);

        assertNotNull(dto);
        assertEquals(entity.getId(), dto.getId());
        assertEquals("description", dto.getDescription());
        assertEquals(recipes, dto.getRecipes());
    }

    @Test
    void toEntity() {
        CategoryDto dto = new CategoryDto();
        dto.setId(1L);
        dto.setDescription("description");
        dto.setRecipes(recipes);

        Category entity = mapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals(1L, entity.getId());
        assertEquals("description", entity.getDescription());
        assertEquals(recipes, entity.getRecipes());
    }
}