package com.omniasumus.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utenti")
public class UserEntity {

    public enum Role {
        ADMIN, USER
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ricetta_id")
    @JsonBackReference
    private RicetteEntity ricetta;

    @Column(name = "username", unique = true, nullable = false)
    @Size(max = 30, message = "Username must be at most 30 characters")
    private String username;

    @Column(name = "password", nullable = false)
    @Size(max = 30, message = "Password must be at most 30 characters")
    private String password;

    @Column(name = "nome")
    @Size(max = 60, message = "Name must be at most 60 characters")
    private String nome;

    @Column(name = "cognome")
    @Size(max = 60, message = "Surname must be at most 60 characters")
    private String cognome;

    @Column(name = "email", unique = true, nullable = false)
    @Email(regexp = ".+@.+\\..{2,3}", message = "Email must be valid")
    @Size(max = 60, message = "Email must be at most 60 characters")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RicetteEntity getRicetta() {
        return ricetta;
    }

    public void setRicetta(RicetteEntity ricetta) {
        this.ricetta = ricetta;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // ToString
    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}