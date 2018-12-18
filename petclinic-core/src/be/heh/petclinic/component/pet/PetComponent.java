package be.heh.petclinic.component.pet;

import be.heh.petclinic.domain.Pet;

import java.util.Collection;

public interface PetComponent {
    Collection<Pet> getPets();

    Collection<Pet> getPets(int ownerId);

    void addPet(Pet pet);

    void updatePet(int id, Pet updatePet);

    void deletePet(int id);
}
