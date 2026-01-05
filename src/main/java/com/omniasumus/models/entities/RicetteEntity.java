package com.omniasumus.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ricette")
public class RicetteEntity {

    public enum Portata {
        AMUSE_BOUCHE, ANTIPASTI, PRIMI, SECONDI, CONTORNI, DESSERT, FRUTTA
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titolo", nullable = false)
    @Size(max = 60, message = "Il titolo deve essere di massimo 60 caratteri")
    @NotNull(message = "Il titolo non può essere nullo")
    private String titolo;

    @Enumerated(EnumType.STRING)
    @Column(name = "portata", nullable = false)
    private Portata portata;

    @Column(name = "procedimento", length = 1000)
    @Size(max = 1000, message = "Il procedimento deve essere di massimo 1000 caratteri")
    private String procedimento;

    // ---- Ingredienti (One To Many) ----
    @OneToMany(mappedBy = "ricetta", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<IngredientiEntity> ingredienti;

    // ---- Utente autore della ricetta (Many To One) ----
    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    @JsonBackReference
    private UserEntity utente;
}