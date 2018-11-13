package be.heh.petclinic.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    Pet pet;

    @BeforeEach
    void setUp() {
        pet = new Pet("Buzz",new GregorianCalendar(2018,10,25),TypePet.rabbit);
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
    void setName() {
        pet.setName("Roger");
        assertEquals("Roger",pet.getName());
    }

    @Test
    void setBirthdate() {
        pet.setBirthdate(new GregorianCalendar(2016,03,13));
        assertEquals(new GregorianCalendar(2016,03,13),pet.getBirthdate());
    }

    @Test
    void setType() {
        pet.setType(TypePet.hamster);
        assertEquals(TypePet.hamster,pet.getType());
    }
}