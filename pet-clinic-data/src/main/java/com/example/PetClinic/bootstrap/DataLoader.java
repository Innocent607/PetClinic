package com.example.PetClinic.bootstrap;

import com.example.PetClinic.model.Owner;
import com.example.PetClinic.model.Vet;
import com.example.PetClinic.services.OwnerService;
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

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception
    {
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
