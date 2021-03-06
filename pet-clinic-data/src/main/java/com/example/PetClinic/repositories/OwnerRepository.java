package com.example.PetClinic.repositories;

import com.example.PetClinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Onalethata I. L. Maswabi
 * AKA Inno607
 */

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName (String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
