package com.omniasumus.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientiDto {

    private Long id; // ID dell'ingrediente
    private String ingrediente; // Nome dell'ingrediente
    private Long ricettaId; // ID della ricetta a cui appartiene l'ingrediente
}