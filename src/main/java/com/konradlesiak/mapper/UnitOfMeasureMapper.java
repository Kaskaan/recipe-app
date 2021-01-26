package com.konradlesiak.mapper;

import com.konradlesiak.domain.UnitOfMeasure;
import com.konradlesiak.dto.UnitOfMeasureDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UnitOfMeasureMapper {

    UnitOfMeasureMapper INSTANCE = Mappers.getMapper(UnitOfMeasureMapper.class);

    UnitOfMeasureDto toDto(UnitOfMeasure entity);
    UnitOfMeasure toEntity(UnitOfMeasureDto unitOfMeasureDto);
}
