package com.example.PetClinic.config;

import com.example.pets.PetService;
import com.example.pets.PetServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

public class PetServiceConfig {

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Profile({"cat"})
    @Bean
    PetService catService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }
}
