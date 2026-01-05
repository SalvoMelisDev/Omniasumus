package com.omniasumus.services.impl;

import com.omniasumus.models.dto.IngredientiDto;
import com.omniasumus.models.entities.IngredientiEntity;
import com.omniasumus.repositories.IngredientiRepository;
import com.omniasumus.services.IngredientiService;
import com.omniasumus.services.mappers.IngredientiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientiServiceImpl implements IngredientiService {
    @Autowired
    private IngredientiRepository ingredientiRepository;

    @Autowired
    private IngredientiMapper ingredientiMapper;

    @Override
    public IngredientiDto insert(IngredientiDto obj) {
        IngredientiEntity entity = ingredientiMapper.toEntity(obj);
        IngredientiEntity savedEntity = ingredientiRepository.save(entity);
        return ingredientiMapper.toDto(savedEntity);
    }

    @Override
    public IngredientiDto update(IngredientiDto obj) {
        IngredientiEntity entity = ingredientiMapper.toEntity(obj);
        IngredientiEntity updatedEntity = ingredientiRepository.save(entity);
        return ingredientiMapper.toDto(updatedEntity);
    }

    @Override
    public IngredientiDto findById(Long id) {
        Optional<IngredientiEntity> optionalEntity = ingredientiRepository.findById(id);
        return optionalEntity.map(ingredientiMapper::toDto).orElse(null);
    }

    @Override
    public List<IngredientiDto> findAll() {
        List<IngredientiEntity> entities = ingredientiRepository.findAll();
        return ingredientiMapper.toDto(entities);
    }

    @Override
    public List<IngredientiDto> findByNomeLikeIgnoreCaseOrderByNome(String valore) {
    return null;
    }

    @Override
    public List<IngredientiDto> findByRicettaId(Long ricettaId) {
        List<IngredientiEntity> entities = ingredientiRepository.findByRicettaId(ricettaId);
        return ingredientiMapper.toDto(entities);
    }

    @Autowired
    public IngredientiServiceImpl(IngredientiRepository ingredientiRepository) {
        this.ingredientiRepository = ingredientiRepository;
    }

    public void delete(Long id) {
        ingredientiRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}