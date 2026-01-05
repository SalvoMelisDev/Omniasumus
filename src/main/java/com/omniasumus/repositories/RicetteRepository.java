package com.omniasumus.repositories;

import com.omniasumus.models.entities.IngredientiEntity;
import com.omniasumus.models.entities.RicetteEntity;
import com.omniasumus.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RicetteRepository extends JpaRepository<RicetteEntity, Long> {

    // Trova una ricetta per ID
    @Override
    Optional<RicetteEntity> findById(Long id);

    // Trova tutte le ricette
    @Override
    List<RicetteEntity> findAll();

    // Trova ricette per titolo
    List<RicetteEntity> findByTitolo(String titolo);

    // Trova l'utente collegato a una ricetta
    @Query("SELECT r.utente FROM RicetteEntity r WHERE r.id = :ricettaId")
    Optional<UserEntity> findUtenteByRicettaId(@Param("ricettaId") Long ricettaId);

    // Trova tutti gli ingredienti di una ricetta
    @Query("SELECT i FROM IngredientiEntity i WHERE i.ricetta.id = :ricettaId")
    List<IngredientiEntity> findIngredientiByRicettaId(@Param("ricettaId") Long ricettaId);
}