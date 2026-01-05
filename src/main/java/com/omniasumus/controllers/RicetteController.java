package com.omniasumus.controllers;

import com.omniasumus.business.RicetteBusiness;
import com.omniasumus.models.dto.RicetteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/ricette", produces = "application/json")
public class RicetteController {
    @Autowired
    private RicetteBusiness ricetteBusiness;

    @GetMapping("/{ricId}")
    public ResponseEntity<RicetteDto> getRicetta(@PathVariable("ricId") Long valore) {
        RicetteDto ricetteDto = ricetteBusiness.getRicettaById(valore);
        if (ricetteDto != null) {
            return new ResponseEntity<>(ricetteDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<List<RicetteDto>> getRicettaAll() {
        List<RicetteDto> ricetteDto = ricetteBusiness.getRicette();
        if (ricetteDto != null) {
            return new ResponseEntity<>(ricetteDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(path = "/new", consumes = "application/json")
    public ResponseEntity<RicetteDto> insertRicetta(@RequestBody RicetteDto nuovaRicetta) {

        RicetteDto ricetteDto = ricetteBusiness.aggiungiRicetta(nuovaRicetta);

        if (ricetteDto != null) {
            return new ResponseEntity<>(ricetteDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(path = "/aggiungi", consumes = "application/json")
    public ResponseEntity<RicetteDto> aggiungiRicetta(@RequestBody RicetteDto nuovaRicetta) {
        RicetteDto ricettaInserita = ricetteBusiness.aggiungiRicetta(nuovaRicetta);
        if (ricettaInserita != null) {
            // È buona pratica restituire 201 (CREATED) per una creazione
            return new ResponseEntity<>(ricettaInserita, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("rimuovi/{id}")
    public ResponseEntity<Void> deleteRicetta(@PathVariable Long id) {
        ricetteBusiness.deleteRicetta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/risultato/{nome}")
    public ResponseEntity<List<RicetteDto>> getRisultato(@PathVariable("nome") String nome) {

        List<RicetteDto> ricetteDto = ricetteBusiness.findByTitolo(nome);
        if (ricetteDto != null && !ricetteDto.isEmpty()) {
            return new ResponseEntity<>(ricetteDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(List.of(), HttpStatus.OK);
        }
    }
}