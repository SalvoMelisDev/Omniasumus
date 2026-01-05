package com.omniasumus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Applica a tutti gli endpoint
                .allowedOrigins("http://localhost:4200") // Consenti richieste dal front-end Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Metodi consentiti
                .allowedHeaders("*") // Tutti gli header consentiti
                .allowCredentials(true); // Consenti credenziali (cookie, token, ecc.)
    }
}