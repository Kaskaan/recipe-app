package com.konradlesiak.mapper;

import com.konradlesiak.domain.Notes;
import com.konradlesiak.domain.Recipe;
import com.konradlesiak.dto.NotesDto;
import com.konradlesiak.dto.RecipeDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesMapperTest {

    NotesMapper mapper = NotesMapper.INSTANCE;

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
        Notes entity = new Notes();
        entity.setId(1L);
        assertNotNull(mapper.toDto(entity));
    }

    @Test
    void testToEntityNotEmptyObject() {
        NotesDto dto = new NotesDto();
        dto.setId(1L);
        assertNotNull(mapper.toEntity(dto));
    }

    @Test
    void toDto() {
        Notes entity = new Notes();
        entity.setId(1L);
        entity.setRecipeNotes("recipe notes");
        entity.setRecipe(new Recipe());

        final NotesDto dto = mapper.toDto(entity);

        assertNotNull(entity);
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getRecipeNotes(), dto.getRecipeNotes());
        assertEquals(entity.getRecipe().getId(), dto.getRecipe().getId());
    }

    @Test
    void toEntity() {
        NotesDto dto = new NotesDto();
        dto.setId(1L);
        dto.setRecipeNotes("recipe notes");
        RecipeDto recipe = new RecipeDto();
        recipe.setNotes(new NotesDto());
        dto.setRecipe(recipe);

        Notes entity = mapper.toEntity(dto);

        assertNotNull(dto);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getRecipeNotes(), entity.getRecipeNotes());
        assertEquals(dto.getRecipe().getId(), entity.getRecipe().getId());
    }
}