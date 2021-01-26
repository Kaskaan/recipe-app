package com.konradlesiak.mapper;

import com.konradlesiak.domain.UnitOfMeasure;
import com.konradlesiak.dto.UnitOfMeasureDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureMapperTest {

    UnitOfMeasureMapper mapper = UnitOfMeasureMapper.INSTANCE;

    @BeforeEach
    void setUp() {
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
        assertNotNull(mapper.toDto(new UnitOfMeasure()));
    }

    @Test
    void testToEntityNotEmptyObject() {
        assertNotNull(mapper.toEntity(new UnitOfMeasureDto()));
    }

    @Test
    void toDto() {
        UnitOfMeasure entity = new UnitOfMeasure();
        entity.setId(1L);
        entity.setUnitName("unit name");

        final UnitOfMeasureDto dto = mapper.toDto(entity);

        assertNotNull(dto);
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getUnitName(), dto.getUnitName());
    }

    @Test
    void toEntity() {
        UnitOfMeasureDto dto = new UnitOfMeasureDto();
        dto.setId(1L);
        dto.setUnitName("unit name");

        final UnitOfMeasure entity = mapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getUnitName(), entity.getUnitName());
    }
}