package com.konradlesiak.mapper;

import com.konradlesiak.domain.UnitOfMeasure;
import com.konradlesiak.dto.UnitOfMeasureDto;
import org.mapstruct.Mapper;

@Mapper
public interface UnitOfMeasureMapper {

    UnitOfMeasureDto toDto(UnitOfMeasure entity);
    UnitOfMeasure toEntity(UnitOfMeasureDto unitOfMeasureDto);
}
