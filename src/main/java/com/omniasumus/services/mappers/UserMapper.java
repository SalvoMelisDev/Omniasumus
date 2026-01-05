package com.omniasumus.services.mappers;

import com.omniasumus.models.dto.UserDto;
import com.omniasumus.models.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Conversione da Entity a DTO
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "cognome", target = "cognome")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "role", target = "role")
    UserDto toDto(UserEntity userEntity);

    // Conversione da DTO a Entity
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "cognome", target = "cognome")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "email", target = "email")
    @Mapping(target = "role", source = "role", qualifiedByName = "setDefaultRole")
    UserEntity toEntity(UserDto userDto);

    @Named("setDefaultRole")
    default String setDefaultRole(String role) {
        return (role == null || role.isEmpty()) ? "USER" : role;
    }
}