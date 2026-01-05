package com.omniasumus.models.dto;

import com.omniasumus.models.entities.RicetteEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RicetteDto {

    private Long id;
    private String titolo;
    private RicetteEntity.Portata portata;
    private String procedimento;

    @Column(name = "ingrediente")
    private String ingrediente;

    @ManyToOne
    @JoinColumn(name = "ricetta_id")
    @JsonBackReference
    private RicetteEntity ricetta;
}