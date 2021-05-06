package services;

import com.example.PetClinic.model.Owner;
import com.example.PetClinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);


}
