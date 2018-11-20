package be.heh.petclinic.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    Pet pet;

    @BeforeEach
    void setUp() {
        pet = new Pet(0,"Buzz",2018,10,25,TypePet.rabbit,5);
    }

    @Test
    void getId() {
        assertEquals(0,pet.getId());
    }

    @Test
    void getName() {
        assertEquals("Buzz",pet.getName());
    }

    @Test
    void getBirthdate() {
        assertEquals(new GregorianCalendar(2018,10,25),pet.getBirthdate());
    }

    @Test
    void getType() {
        assertEquals(TypePet.rabbit,pet.getType());
    }

    @Test
    void getOwnerId(){
        assertEquals(5,pet.getOwnerId());
    }

    @Test
    void setName() {
        pet.setName("Roger");
        assertEquals("Roger",pet.getName());
    }

    @Test
    void setBirthdate() {
        pet.setBirthdate(2016,02,13);
        assertEquals(new GregorianCalendar(2016,02,13),pet.getBirthdate());
    }

    @Test
    void setType() {
        pet.setType(TypePet.hamster);
        assertEquals(TypePet.hamster, pet.getType());
    }
}