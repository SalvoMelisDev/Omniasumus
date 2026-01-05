package com.omniasumus.business;

import com.omniasumus.models.dto.RicetteDto;
import com.omniasumus.models.entities.RicetteEntity;
import com.omniasumus.repositories.RicetteRepository;
import com.omniasumus.services.RicetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RicetteBusiness {
    @Autowired
    private RicetteService ricetteService;

    public RicetteDto getRicettaById(Long id) {
        RicetteDto rd = ricetteService.findById(id);
        return rd;
    }

    public List<RicetteDto> getRicette() {
        List<RicetteDto> rd = ricetteService.findAll();
        return rd;
    }

    public RicetteDto aggiungiRicetta(RicetteDto ricetta) {
        RicetteDto rd = ricetteService.insert(ricetta);
        return rd;
    }

    @Autowired
    private RicetteRepository ricetteRepository;

    public List<RicetteDto> findByTitolo(String nome) {
        String nomeLike = "%" + nome + "%";
        List<RicetteEntity> ricetteEntities = ricetteRepository.findByTitolo(nomeLike);
        return convertToDtoList(ricetteEntities);
    }

    private List<RicetteDto> convertToDtoList(List<RicetteEntity> ricetteEntities) {
        return ricetteEntities.stream()
                .map(this::convertToDto)
                .toList();
    }

    private RicetteDto convertToDto(RicetteEntity ricettaEntity) {
        RicetteDto ricettaDto = new RicetteDto();
        ricettaDto.setId(ricettaEntity.getId());
        ricettaDto.setTitolo(ricettaEntity.getTitolo());
        ricettaDto.setPortata(ricettaEntity.getPortata());
        ricettaDto.setProcedimento(ricettaEntity.getProcedimento()); // Aggiunto il campo procedimento
        return ricettaDto;
    }

    public void deleteRicetta(Long id) {
        ricetteService.delete(id);
    }
}