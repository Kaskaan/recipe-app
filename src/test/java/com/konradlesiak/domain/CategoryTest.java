package com.konradlesiak.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {

    Category category;

    @BeforeEach
    public void setUp() {
        category = new Category();
    }

    @Test
    void getId() {
        Long idValue = 3L;

        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }

    @Test
    void getDescription() {
        String categoryValue = "test description";

        category.setDescription(categoryValue);

        assertEquals(categoryValue, category.getDescription());
    }

    @Test
    void getRecipes() {

        final Set<Recipe> recipes = category.getRecipes();

    }
}