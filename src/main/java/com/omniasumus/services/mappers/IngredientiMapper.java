package com.omniasumus.services.mappers;

import com.omniasumus.models.dto.IngredientiDto;
import com.omniasumus.models.entities.IngredientiEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngredientiMapper {
    IngredientiEntity toEntity(IngredientiDto ingredientiDto);
    IngredientiDto toDto(IngredientiEntity ingredientiEntity);
    List<IngredientiDto> toDto (List<IngredientiEntity> ingredientiEntities);
}
