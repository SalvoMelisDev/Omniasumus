package com.omniasumus.models.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.omniasumus.models.entities.RicetteEntity;
import com.omniasumus.models.entities.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private Long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private String email;
	private String role;

	@Column(name = "ricetta")
	private RicetteEntity ricetta;

	@ManyToOne
	@JoinColumn(name = "utente_id")
	@JsonBackReference
	private UserEntity utente;
}