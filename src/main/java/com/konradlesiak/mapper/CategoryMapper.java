package com.konradlesiak.mapper;

import com.konradlesiak.domain.Category;
import com.konradlesiak.dto.CategoryDto;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {

    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto categoryDto);
}
