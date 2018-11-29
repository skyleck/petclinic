package be.heh.petclinic.component.owner;

import be.heh.petclinic.AbstractComponentTestBase;
import be.heh.petclinic.domain.Exception.NullValueException;
import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.domain.Pet;
import be.heh.petclinic.domain.Exception.TelephoneNumbeNotValid;
import be.heh.petclinic.domain.TypePet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class OwnerComponentTests extends AbstractComponentTestBase {

    private ArrayList<Owner> list;

    @BeforeEach
    public void setUp() throws TelephoneNumbeNotValid, NullValueException {
        list = new ArrayList<Owner>();

        ArrayList<Pet> petsOwner1 = new ArrayList<Pet>();
        petsOwner1.add(new Pet(1,"Grandma",2000,01,1,TypePet.cat,1));
        petsOwner1.add(new Pet(2,"Kaa",2018,10,25,TypePet.snake,1));
        petsOwner1.add(new Pet(3,"Leo",2010,9,07,TypePet.hamster,1));

        ArrayList<Pet> petsOwner2 = new ArrayList<Pet>();
        petsOwner2.add(new Pet(4,"Basil",2012,8,06,TypePet.hamster,2));

        ArrayList<Pet> petsOwner3 = new ArrayList<Pet>();
        petsOwner3.add(new Pet(5,"Jewel",2010,3,07,TypePet.dog,3));
        petsOwner3.add(new Pet(6,"Rosy",2011,4,17,TypePet.dog,3));

        list.add(new Owner(1,"Franklin","George","10 W.Liberty St.","Madison",
                "6085551023",petsOwner1));
        list.add(new Owner(2,"Davis","Betty","638 Cardinal Ave.","Sun Prairie",
                "6085551749",petsOwner2));
        list.add(new Owner(3,"Rodriquez","Eduardo","2693 Commerce St.","McFarland",
                "6085558763",petsOwner3));
    }

    @Test
    void test() throws TelephoneNumbeNotValid, NullValueException {
        getOwner();
        getOwners();
        addOwner();
        updateOwner();
    }

    void getOwner(){
        assertEquals(getOwnerComponent().getOwner(1, getPetComponent().getPets(1)),list.get(0));
        assertEquals(getOwnerComponent().getOwner(2, getPetComponent().getPets(2)),list.get(1));
        assertEquals(getOwnerComponent().getOwner(3, getPetComponent().getPets(3)),list.get(2));
        assertEquals(getOwnerComponent().getOwner(4, getPetComponent().getPets(4)),null);
    }

    void getOwners() throws TelephoneNumbeNotValid {
        assertIterableEquals(list, getOwnerComponent().getOwners(getPetComponent().getPets()));
    }

    void addOwner() throws TelephoneNumbeNotValid, NullValueException {
        ArrayList<Pet> petsOwner = new ArrayList<Pet>();
        Owner owner = new Owner(4,"test","test","test","test",
                "0425636696",petsOwner);
        getOwnerComponent().addOwner(owner);
        ArrayList<Owner> loadOwner = (ArrayList<Owner>) getOwnerComponent().getOwners(getPetComponent().getPets());
        assertEquals(owner, loadOwner.get(loadOwner.size()-1));
    }

    void updateOwner() throws TelephoneNumbeNotValid, NullValueException {
        ArrayList<Pet> petsOwner = new ArrayList<Pet>();
        petsOwner.add(new Pet(7,"test",2005,12,05,TypePet.snake,4));
        Owner owner = new Owner(4, "Louzo","Stan","89 Avenue du Roi","Mouscron",
                "0479636532",petsOwner);
        getOwnerComponent().updateOwner(4,owner);
        ArrayList<Owner> loadOwner = (ArrayList<Owner>) getOwnerComponent().getOwners(getPetComponent().getPets());
        assertEquals(owner, loadOwner.get(loadOwner.size()-1));
    }
}

