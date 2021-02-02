package com.konradlesiak.mapper;

import com.konradlesiak.domain.Difficulty;
import com.konradlesiak.domain.Notes;
import com.konradlesiak.domain.Recipe;
import com.konradlesiak.dto.NotesDto;
import com.konradlesiak.dto.RecipeDto;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class RecipeMapperTest {

    final RecipeMapper mapper = RecipeMapper.INSTANCE;

    final Byte[] image = new Byte[1];

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
        Recipe entity = new Recipe();
        entity.setId(1L);
        entity.setCategories(new HashSet<>());
        entity.setCookTime(10);
        entity.setDescription("description");
        entity.setDifficulty(Difficulty.EASY);
        entity.setDirections("directions");
        entity.setImage(image);
        entity.setIngredients(new HashSet<>());
        entity.setNotes(new Notes());
        entity.setPrepTime(30);
        entity.setServings(2);
        entity.setSource("source");

        assertNotNull(mapper.toDto(entity));
    }

    @Test
    void testToEntityNotEmptyObject() {
        RecipeDto dto = new RecipeDto();
        dto.setId(1L);
        dto.setCategories(new HashSet<>());
        dto.setCookTime(10);
        dto.setDescription("description");
        dto.setDifficulty(Difficulty.EASY);
        dto.setDirections("directions");
        dto.setImage(image);
        dto.setIngredients(new HashSet<>());
        dto.setNotes(new NotesDto());
        dto.setPrepTime(30);
        dto.setServings(2);
        dto.setSource("source");

        assertNotNull(mapper.toEntity(dto));
    }

    @Test
    void toDto() {
        Recipe entity = new Recipe();
        entity.setId(1L);
        entity.setCategories(new HashSet<>());
        entity.setCookTime(10);
        entity.setDescription("description");
        entity.setDifficulty(Difficulty.EASY);
        entity.setDirections("directions");
        entity.setImage(image);
        entity.setIngredients(new HashSet<>());
        entity.setNotes(new Notes());
        entity.setPrepTime(30);
        entity.setServings(2);
        entity.setSource("source");

        final RecipeDto dto = mapper.toDto(entity);

        assertNotNull(dto);
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getDescription(), dto.getDescription());
        assertEquals(entity.getPrepTime(), dto.getPrepTime());
        assertEquals(entity.getCookTime(), dto.getCookTime());
        assertEquals(entity.getServings(), dto.getServings());
        assertEquals(entity.getSource(), dto.getSource());
        assertEquals(entity.getUrl(), dto.getUrl());
        assertEquals(entity.getDirections(), dto.getDirections());
        assertEquals(entity.getDifficulty(), dto.getDifficulty());
        assertEquals(Byte[].class, dto.getImage().getClass());
        assertEquals(entity.getNotes().getId(), dto.getNotes().getId());
        assertEquals(entity.getIngredients().size(), dto.getIngredients().size());
        assertEquals(entity.getCategories().size(), dto.getCategories().size());
    }

    @Test
    void toEntity() {
        RecipeDto dto = new RecipeDto();
        dto.setId(1L);
        dto.setCategories(new HashSet<>());
        dto.setCookTime(10);
        dto.setDescription("description");
        dto.setDifficulty(Difficulty.EASY);
        dto.setDirections("directions");
        dto.setImage(image);
        dto.setIngredients(new HashSet<>());
        dto.setNotes(new NotesDto());
        dto.setPrepTime(30);
        dto.setServings(2);
        dto.setSource("source");

        final Recipe entity = mapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getDescription(), entity.getDescription());
        assertEquals(dto.getPrepTime(), entity.getPrepTime());
        assertEquals(dto.getCookTime(), entity.getCookTime());
        assertEquals(dto.getServings(), entity.getServings());
        assertEquals(dto.getSource(), entity.getSource());
        assertEquals(dto.getUrl(), entity.getUrl());
        assertEquals(dto.getDirections(), entity.getDirections());
        assertEquals(dto.getDifficulty(), entity.getDifficulty());
        assertEquals(Byte[].class, entity.getImage().getClass());
        assertEquals(dto.getNotes().getId(), entity.getNotes().getId());
        assertEquals(dto.getIngredients().size(), entity.getIngredients().size());
        assertEquals(dto.getCategories().size(), entity.getCategories().size());
    }
}