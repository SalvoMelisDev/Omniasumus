package com.omniasumus.controllers;

import com.omniasumus.business.IngredientiBusiness;
import com.omniasumus.business.ResourceNotFoundException;
import com.omniasumus.models.dto.IngredientiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "ingredienti", produces = "application/json")
public class IngredientiController {

    @Autowired
    private IngredientiBusiness ingredientiBusiness;

    /**
     * Questo metodo è utile ad inserire un nuovo ingrediente
     */
    @PostMapping("/new")
    public ResponseEntity<IngredientiDto> inserisciIngrediente(@RequestBody IngredientiDto ingredientiDto) {
        IngredientiDto savedDto = ingredientiBusiness.inserisciIngrediente(ingredientiDto);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

    /**
     * Aggiorna una chiave di ricerca esistente.
     */
    @PutMapping("/update")
    public ResponseEntity<IngredientiDto> aggiornaIngredienti(@RequestBody IngredientiDto ingredientiDto) {
        IngredientiDto updatedDto = ingredientiBusiness.aggiornaIngredienti(ingredientiDto);
        return new ResponseEntity<>(updatedDto, HttpStatus.OK);
    }

    /**
     * Trova una chiave di ricerca per ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<IngredientiDto> trovaIngredientiPerId(@PathVariable Long id) {
        IngredientiDto dto = ingredientiBusiness.trovaIngredientiPerId(id);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Restituisce tutti gli ingredienti presenti
     */
    @GetMapping("/all")
    public ResponseEntity<List<IngredientiDto>> trovaTuttiGliIngredienti() {
        List<IngredientiDto> dtoList = ingredientiBusiness.trovaTuttiGliIngredienti();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    /**
     * Trova tutti gli ingredienti di una ricetta attraverso l'ID
     */
    @GetMapping("/ricetta/{ricettaId}")
    public ResponseEntity<List<IngredientiDto>> trovaIngredientiPerRicettaId(@PathVariable Long ricettaId) {
        List<IngredientiDto> dtoList = ingredientiBusiness.trovaIngredientiPerRicettaId(ricettaId);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    /**
     * Trova gli ingredienti per nome
     */
    @GetMapping("/cerca")
    public ResponseEntity<List<IngredientiDto>> trovaIngredientiPerNome(@RequestParam String valore) {
        List<IngredientiDto> dtoList = ingredientiBusiness.trovaIngredientiPerNome(valore);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteIngrediente(@PathVariable Long id) {
        try {
            ingredientiBusiness.eliminaIngrediente(id);
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.noContent().build();
    }
}