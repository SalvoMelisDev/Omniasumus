package com.omniasumus.business;

import com.omniasumus.models.dto.IngredientiDto;
import com.omniasumus.services.IngredientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IngredientiBusiness {

    @Autowired
    private IngredientiService ingredientiService;

    /**
     * Questo metodo consente di inserire un nuovo ingrediente nella ricetta
     */
    public IngredientiDto inserisciIngrediente(IngredientiDto ingredientiDto) {
        return ingredientiService.insert(ingredientiDto);
    }

    /**ingredienti
     * Aggiorna un ingrediente esistente.
     */
    public IngredientiDto aggiornaIngredienti(IngredientiDto ingredientiDto) {
        return ingredientiService.update(ingredientiDto);
    }

    /**
     * Trova un ingrediente per ID.
     */
    public IngredientiDto trovaIngredientiPerId(Long id) {
        return ingredientiService.findById(id);
    }

    /**
     * Restituisce tutti gli ingredienti presenti nel database.
     */
    public List<IngredientiDto> trovaTuttiGliIngredienti() {
        return ingredientiService.findAll();
    }

    /**
     * Trova tutti gli ingredienti associati a una specifica ricetta.
     */
    public List<IngredientiDto> trovaIngredientiPerRicettaId(Long ricettaId) {
        return ingredientiService.findByRicettaId(ricettaId);
    }

    /**
     * Trova gli ingredienti per nome (non implementato nel service).
     */
    public List<IngredientiDto> trovaIngredientiPerNome(String valore) {
        return ingredientiService.findByNomeLikeIgnoreCaseOrderByNome(valore);
    }

    public void eliminaIngrediente(Long id) throws ResourceNotFoundException {
        if (!ingredientiService.existsById(id)) {
            throw new ResourceNotFoundException("Ingrediente non trovato con id: " + id);
        }
        ingredientiService.delete(id);
    }
}