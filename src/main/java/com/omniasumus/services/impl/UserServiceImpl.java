package com.omniasumus.services.impl;

import com.omniasumus.models.dto.UserDto;
import com.omniasumus.models.entities.UserEntity;
import com.omniasumus.repositories.UserRepository;
import com.omniasumus.services.UserService;
import com.omniasumus.services.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto findByUsername(String username) {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        return user.map(userMapper::toDto).orElse(null);
    }

    @Override
    @Transactional
    public UserDto registerUser(UserDto userDto) {
        // Verifica se l'username è già in uso
        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new RuntimeException("Username già in uso");
        }

        // Verifica se l'email è già in uso
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new RuntimeException("Email già in uso");
        }

        // Mappa il DTO all'entità e salva l'utente
        UserEntity userEntity = userMapper.toEntity(userDto);
        UserEntity savedUser = userRepository.save(userEntity);

        // Mappa l'entità salvata al DTO e restituiscila
        return userMapper.toDto(savedUser);
    }
}