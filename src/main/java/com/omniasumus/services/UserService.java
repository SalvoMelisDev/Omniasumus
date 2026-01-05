package com.omniasumus.services;

import com.omniasumus.models.dto.UserDto;

public interface UserService {

    /**
     * Trova un utente tramite username.
     *
     * @param username L'username dell'utente da cercare.
     * @return Un oggetto UserDto corrispondente all'utente trovato, o null se non trovato.
     */
    UserDto findByUsername(String username);

    /**
     * Registra un nuovo utente nel sistema.
     *
     * @param userDto L'oggetto UserDto contenente i dati dell'utente da registrare.
     * @return Un oggetto UserDto rappresentante l'utente registrato.
     * @throws RuntimeException Se l'username o l'email sono già in uso.
     */
    UserDto registerUser(UserDto userDto);
}