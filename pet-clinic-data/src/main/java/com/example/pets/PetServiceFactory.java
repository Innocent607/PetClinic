package com.example.pets;

public class PetServiceFactory {

    public PetService getPetService(String petType){
        switch (petType) {
            case "dog":
                return new DogService();

            case "cat":
                return new CatService();

            default:
                return new DogService();
        }
    }

}
