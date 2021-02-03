package com.konradlesiak.mapper;

import com.konradlesiak.domain.Category;
import com.konradlesiak.domain.Notes;
import com.konradlesiak.domain.Recipe;
import com.konradlesiak.dto.CategoryDto;
import com.konradlesiak.dto.NotesDto;
import com.konradlesiak.dto.RecipeDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapperTest {

    final CategoryMapper mapper = new CategoryMapperImpl();
    Set<Recipe> recipes;
    Set<RecipeDto> recipesDtoSet;

    @BeforeEach
    void setUp() {
        recipes = new HashSet<>();
        recipes.add(new Recipe());
        recipesDtoSet = new HashSet<>();
        RecipeDto e = new RecipeDto();
        recipesDtoSet.add(e);
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
    }

    @Test
    void toEntity() {
        CategoryDto dto = new CategoryDto();
        dto.setId(1L);
        dto.setDescription("description");

        Category entity = mapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals(1L, entity.getId());
        assertEquals("description", entity.getDescription());
        assertEquals(recipes.size(), entity.getRecipes().size());
    }
}