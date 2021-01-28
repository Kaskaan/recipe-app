package com.konradlesiak.service;

import com.konradlesiak.dto.UnitOfMeasureDto;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureDto> findAll();
}
