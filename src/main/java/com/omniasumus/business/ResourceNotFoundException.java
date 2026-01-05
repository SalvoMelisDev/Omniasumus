package com.omniasumus.business;

public class ResourceNotFoundException extends Throwable {
    public ResourceNotFoundException(String s) {
        s = "Nessun risultato trovato";
    }
}
