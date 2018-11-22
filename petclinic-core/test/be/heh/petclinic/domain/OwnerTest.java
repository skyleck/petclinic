package be.heh.petclinic.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerTest {

    Owner owner;
    ArrayList<Pet> pets;

    @BeforeEach
    void setUp() throws Exception {
        this.pets = new ArrayList<Pet>();
        this.pets.add(new Pet(1,"Grandma",2000,01,1,TypePet.cat,1));
        this.pets.add(new Pet(1,"Kaa",2018,10,25,TypePet.snake,1));
        this.pets.add(new Pet(1,"Leo",2010,9,07,TypePet.hamster,1));
        this.owner = new Owner(1,"Hempte","Maxime","18 Rue Du Cirque","Circus",
                            "0472854896",this.pets);
    }

    @Test
    void getId(){
        assertEquals(1,owner.getId());
    }

    @Test
    void getLastname() {
        assertEquals("Hempte",owner.getLastname());
    }

    @Test
    void getFirstname() {
        assertEquals("Maxime",owner.getFirstname());
    }

    @Test
    void getAddress() {
        assertEquals("18 Rue Du Cirque",owner.getAddress());
    }

    @Test
    void getCity() {
        assertEquals("Circus",owner.getCity());
    }

    @Test
    void getTelephone() {
        assertEquals("0472854896",owner.getTelephone());
    }

    @Test
    void getPets(){
        assertIterableEquals(pets,owner.getPets());
    }

    @Test
    void setLastname() {
        owner.setLastname("Harpignies");
        assertEquals("Harpignies",owner.getLastname());
    }

    @Test
    void setFirstname() {
        owner.setFirstname("Adrien");
        assertEquals("Adrien",owner.getFirstname());
    }

    @Test
    void setAddress() {
        owner.setAddress("no address");
        assertEquals("no address",owner.getAddress());
    }

    @Test
    void setCity() {
        owner.setCity("Mons");
        assertEquals("Mons",owner.getCity());
    }

    @Test
    void setTelephone() throws Exception {
        owner.setTelephone("0471829365");
        assertEquals("0471829365",owner.getTelephone());
    }
}
