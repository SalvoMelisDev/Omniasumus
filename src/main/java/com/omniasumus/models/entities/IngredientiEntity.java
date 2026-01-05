package com.omniasumus.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="ingredienti")
public class IngredientiEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="ingrediente")
    @Size(max = 30, message = "Ingredient must be at most 30 characters")
    private String ingrediente;

    @ManyToOne
    @JoinColumn(name = "ricetta_id")
    @JsonBackReference
    private RicetteEntity ricetta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
