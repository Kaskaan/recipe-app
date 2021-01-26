package com.konradlesiak.mapper;

import com.konradlesiak.domain.Notes;
import com.konradlesiak.dto.NotesDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotesMapper {

    NotesMapper INSTANCE = Mappers.getMapper(NotesMapper.class);

    NotesDto toDto(Notes notes);
    Notes toEntity(NotesDto notesDto);
}
