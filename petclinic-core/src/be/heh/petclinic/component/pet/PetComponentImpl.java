package be.heh.petclinic.component.pet;

import be.heh.petclinic.domain.Pet;
import be.heh.petclinic.domain.TypePet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;

class PetComponentImpl implements PetComponent{
    ArrayList<Pet> pets = new ArrayList<Pet>();

    public PetComponentImpl () {
        pets.add(new Pet(0,"Buzz",2018,10,25, TypePet.rabbit));
        pets.add(new Pet(1,"Garfield",2016,05,18,TypePet.cat));
    }

    @Override
    public Collection<Pet> getPets() {
        return pets;
    }

    @Override
    public void addPet(Pet pet) {
        pets.add(pet);
    }

    @Override
    public int searchById(int id){
        if(id < pets.size() && pets.get(id).getId() == id){
            return id;
        }
        for(int i = 0; i < pets.size(); i++){
            if(pets.get(i).getId() == id)
                return  i;
        }
        return -1;
    }

    @Override
    public void updatePet(int id, Pet updatePet) {
        pets.set(id, updatePet);
    }
}
