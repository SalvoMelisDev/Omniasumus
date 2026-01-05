package com.omniasumus.repositories;

import com.omniasumus.models.entities.IngredientiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientiRepository extends JpaRepository<IngredientiEntity, Long> {

    // Trova tutti gli ingredienti
    @Override
    List<IngredientiEntity> findAll();

    // Trova tutti gli ingredienti di una ricetta specifica
    List<IngredientiEntity> findByRicettaId(Long ricettaId);
}