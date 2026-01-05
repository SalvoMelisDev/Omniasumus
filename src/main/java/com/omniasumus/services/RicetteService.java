package com.omniasumus.services;

import com.omniasumus.models.dto.RicetteDto;
import java.util.List;


public interface RicetteService {
    RicetteDto insert(RicetteDto obj);
    RicetteDto update(RicetteDto obj);
    RicetteDto findById(Long valore);
    List<RicetteDto> findAll();
    List<RicetteDto> findByTitolo(String valore);
    void delete(Long id);
}
