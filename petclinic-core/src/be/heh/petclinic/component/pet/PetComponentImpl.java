package be.heh.petclinic.component.pet;

import be.heh.petclinic.domain.Pet;
import be.heh.petclinic.domain.TypePet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;

class PetComponentImpl implements PetComponent{
    private JdbcPetDao petDao;

    @Override
    public Collection<Pet> getPets() {
        return petDao.getPets();
    }

    @Override
    public void addPet(Pet pet) {
        petDao.addPet(pet);
    }

    @Override
    public int searchById(int id){
        //
    }

    @Override
    public void updatePet(int id, Pet updatePet) {
        pets.set(id, updatePet);
    }
}
