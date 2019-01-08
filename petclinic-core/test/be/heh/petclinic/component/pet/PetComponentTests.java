package be.heh.petclinic.component.pet;

import be.heh.petclinic.AbstractComponentTestBase;
import be.heh.petclinic.domain.Exception.NullValueException;
import be.heh.petclinic.domain.Pet;
import be.heh.petclinic.domain.TypePet;
import be.heh.petclinic.domain.Vet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class PetComponentTests extends AbstractComponentTestBase {

    private Collection<Pet> list;

    @BeforeEach
    public void setUp() throws NullValueException {
        list = new ArrayList<Pet>();
        list.add(new Pet(1,"Grandma",2000,01,1,TypePet.cat,1));
        list.add(new Pet(2,"Kaa",2018,10,25,TypePet.snake,1));
        list.add(new Pet(3,"Leo",2010,9,07,TypePet.hamster,1));
        list.add(new Pet(4,"Basil",2012,8,06,TypePet.hamster,2));
        list.add(new Pet(5,"Jewel",2010,3,07,TypePet.dog,3));
        list.add(new Pet(6,"Rosy",2011,4,17,TypePet.dog,3));
    }

    @Test
    void test() throws NullValueException {
        getPets();
        addPet();
        updatePet();
    }

    void getPets() {
        assertIterableEquals(list, getPetComponent().getPets());
    }

    void addPet() throws NullValueException {
        Pet pet = new Pet(7,"Duck",2001,8,06,TypePet.bird,2);
        getPetComponent().addPet(pet);
        ArrayList<Pet> loadPet = (ArrayList<Pet>) getPetComponent().getPets();
        //assertEquals(pet, loadPet.get(loadPet.size()-1));
    }

    void updatePet() throws NullValueException {
        Pet pet = new Pet(6,"Toto",2007,9,07,TypePet.cat,3);
        getPetComponent().updatePet(6,pet);
        ArrayList<Pet> loadPet = (ArrayList<Pet>) getPetComponent().getPets();
        assertEquals(pet, loadPet.get(loadPet.size()-1));
    }
}
