package com.omniasumus.services.impl;

import com.omniasumus.models.dto.RicetteDto;
import com.omniasumus.models.entities.RicetteEntity;
import com.omniasumus.repositories.RicetteRepository;
import com.omniasumus.services.RicetteService;
import com.omniasumus.services.mappers.RicetteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class RicetteServiceImpl implements RicetteService {
    @Autowired
    private RicetteMapper ricetteMapper;

    @Autowired
    private RicetteRepository ricetteRepository;

    @Override
    public RicetteDto insert(RicetteDto obj) {

        RicetteEntity ricetta = ricetteMapper.toEntity(obj);

        RicetteEntity newRicetta = ricetteRepository.save(ricetta);

        RicetteDto newDto = ricetteMapper.toDto(newRicetta);

        return newDto;
    }

    @Override
    public RicetteDto update(RicetteDto obj) {

        RicetteEntity ricetta = ricetteMapper.toEntity(obj);

        RicetteEntity newRicetta = ricetteRepository.save(ricetta);

        RicetteDto newDto = ricetteMapper.toDto(newRicetta);
        return newDto;
    }


    @Override
    public RicetteDto findById(Long valore) {
        /*RicetteEntity ricetta = ricetteRepository.findById(valore).orElse(new RicetteEntity());
        return ricetteMapper.toDto(ricetta);*/

        Optional<RicetteEntity> optionalRicetta = ricetteRepository.findById(valore);
        if (optionalRicetta.isPresent()) {
            RicetteEntity ricetta = optionalRicetta.get();
            return ricetteMapper.toDto(ricetta);
        } else {
            return null;
        }

    }

    @Override
    public List<RicetteDto> findAll() {
        List<RicetteEntity> ricetta = ricetteRepository.findAll();

        if (ricetta != null && !ricetta.isEmpty()) {

            List<RicetteDto> newReDto = ricetteMapper.toDto(ricetta);
            return newReDto;
        } else {
            return null;
        }
    }

    @Override
    public List<RicetteDto> findByTitolo(String valore) {
        List<RicetteEntity> ricetta = ricetteRepository.findByTitolo(valore);

        if (ricetta != null && !ricetta.isEmpty()) {

            List<RicetteDto> newReDto = ricetteMapper.toDto(ricetta);
            return newReDto;
        } else {
            return null;
        }
    }
    @Override
    public void delete(Long id) {
        ricetteRepository.deleteById(id);
    }
}