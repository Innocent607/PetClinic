package com.example.pets;

public class CatService implements PetService {

    @Override
    public String getPetType() {
        return "Cats are the worst";
    }
}
