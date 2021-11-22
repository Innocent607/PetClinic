package com.example.PetClinic.services.springdatajpa;

import com.example.PetClinic.model.Pet;
import com.example.PetClinic.repositories.PetRepository;
import com.example.PetClinic.services.PetService;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Onalethata I. L. Maswabi
 * AKA Inno607
 */

public class PetSDJpaService implements PetService {

    private final PetRepository petRepository;

    public PetSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();

        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);

    }
}
