package com.konradlesiak.mapper;

import com.konradlesiak.domain.Notes;
import com.konradlesiak.dto.NotesDto;
import org.mapstruct.Mapper;

@Mapper
public interface NotesMapper {

    NotesDto toDto(Notes notes);
    Notes toEntity(NotesDto notesDto);
}
