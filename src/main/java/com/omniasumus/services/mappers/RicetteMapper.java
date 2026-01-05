package com.omniasumus.services.mappers;

import com.omniasumus.models.dto.RicetteDto;
import com.omniasumus.models.entities.RicetteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RicetteMapper {

    // Istanza del mapper
    RicetteMapper INSTANCE = Mappers.getMapper(RicetteMapper.class);

    // Conversione da Entity a DTO
    @Mapping(source = "titolo", target = "titolo") // Mappa "titolo" su "titolo"
    @Mapping(source = "portata", target = "portata") // Mappa l'Enum direttamente
    @Mapping(source = "procedimento", target = "procedimento") // Mappa il procedimento

    RicetteDto toDto(RicetteEntity ricetteEntity);

    // Conversione da DTO a Entity
    @Mapping(source = "titolo", target = "titolo") // Mappa "titolo" su "titolo"
    @Mapping(source = "portata", target = "portata") // Mappa l'Enum direttamente
    @Mapping(source = "procedimento", target = "procedimento") // Mappa il procedimento
    RicetteEntity toEntity(RicetteDto ricetteDto);

    // Conversione di una lista di Entity a una lista di DTO
    List<RicetteDto> toDto(List<RicetteEntity> ricetteEntities);
}