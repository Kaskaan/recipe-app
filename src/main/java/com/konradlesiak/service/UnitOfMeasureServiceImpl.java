package com.konradlesiak.service;

import com.konradlesiak.domain.UnitOfMeasure;
import com.konradlesiak.dto.UnitOfMeasureDto;
import com.konradlesiak.mapper.UnitOfMeasureMapper;
import com.konradlesiak.repository.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureMapper unitOfMeasureMapper;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository,
                                    UnitOfMeasureMapper unitOfMeasureMapper) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureMapper = unitOfMeasureMapper;
    }

    @Override
    public Set<UnitOfMeasureDto> findAll() {
        return StreamSupport.stream(unitOfMeasureRepository.findAll()
                .spliterator(), false)
                .map(unitOfMeasureMapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public UnitOfMeasureDto findById(Long id) {
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findById(id);
        return unitOfMeasureMapper.toDto(unitOfMeasure.get());
    }
}
