package be.heh.petclinic.component.pet;

import be.heh.petclinic.domain.Pet;

import java.util.Collection;

public interface PetComponent {
    Collection<Pet> getPets();

    void addPet(Pet pet);

    void updatePet(int id, Pet updatePet);

    int searchById(int id);
}
