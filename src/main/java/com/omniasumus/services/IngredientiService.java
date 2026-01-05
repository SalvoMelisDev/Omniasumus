package com.omniasumus.services;

import com.omniasumus.models.dto.IngredientiDto;
import java.util.List;

public interface IngredientiService {

    IngredientiDto insert(IngredientiDto obj);

    IngredientiDto update(IngredientiDto obj);

    IngredientiDto findById(Long id);

    List<IngredientiDto> findAll();

    List<IngredientiDto> findByNomeLikeIgnoreCaseOrderByNome(String valore);

    List<IngredientiDto> findByRicettaId(Long ricettaId);

    void delete(Long id);

    boolean existsById(Long id);
}