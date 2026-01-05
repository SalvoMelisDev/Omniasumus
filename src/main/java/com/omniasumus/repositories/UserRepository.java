package com.omniasumus.repositories;

import com.omniasumus.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // Trova un utente per username (utente che logga)
    Optional<UserEntity> findByUsername(String username);

    // Trova un utente per email
    Optional<UserEntity> findByEmail(String email);

    // Trova tutti gli utenti
    @Override
    List<UserEntity> findAll();
}