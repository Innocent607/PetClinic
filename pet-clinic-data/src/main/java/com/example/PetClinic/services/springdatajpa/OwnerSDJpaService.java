package com.example.PetClinic.services.springdatajpa;

import com.example.PetClinic.model.Owner;
import com.example.PetClinic.repositories.OwnerRepository;
import com.example.PetClinic.repositories.PetRepository;
import com.example.PetClinic.services.OwnerService;
import com.example.PetClinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Onalethata I. L. Maswabi
 * AKA Inno607
 */

@Service
//@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeService petTypeService;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
                             PetTypeService petTypeService) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        // iterate through the owners' repo and return the owner(s) matching the lastName
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        Optional<Owner> optionalOwner =  ownerRepository.findById(aLong);

        if (optionalOwner.isPresent()) {
            return optionalOwner.get();
        }
        else {
            return null;
        }
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);

    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
