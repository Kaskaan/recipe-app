package com.konradlesiak.config;

import com.konradlesiak.mapper.*;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappersConfiguration {

    @Bean
    public CategoryMapper categoryMapper() {
        return Mappers.getMapper(CategoryMapper.class);
    }

    @Bean
    public IngredientMapper ingredientMapper() {
        return Mappers.getMapper(IngredientMapper.class);
    }

    @Bean
    public NotesMapper notesMapper() {
        return Mappers.getMapper(NotesMapper.class);
    }

    @Bean
    public RecipeMapper recipeMapper() {
        return Mappers.getMapper(RecipeMapper.class);
    }

    @Bean
    public UnitOfMeasureMapper unitOfMeasureMapper() {
        return Mappers.getMapper(UnitOfMeasureMapper.class);
    }
}
