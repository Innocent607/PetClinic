package services;

import com.example.PetClinic.model.Pet;
import com.example.PetClinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
