package com.example.PetClinic.bootstrap;

import com.example.PetClinic.model.Owner;
import com.example.PetClinic.model.PetType;
import com.example.PetClinic.model.Vet;
import com.example.PetClinic.services.OwnerService;
import com.example.PetClinic.services.PetService;
import com.example.PetClinic.services.PetTypeService;
import com.example.PetClinic.services.VetService;
import com.example.PetClinic.services.map.OwnerServiceMap;
import com.example.PetClinic.services.map.VetServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception
    {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Adding Owners to the data table ...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        System.out.println("Added 2 Owners to the database ...");
        System.out.println("Please wait ...");
        System.out.println("Adding Vets to the data table ...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Added 2 Vets to the database ...");
        System.out.println("Operation successful");
        System.out.println("        100%       ");
    }
}
