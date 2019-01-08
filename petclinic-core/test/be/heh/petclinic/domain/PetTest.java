package be.heh.petclinic.domain;

import be.heh.petclinic.domain.Exception.NullValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    Pet pet;

    @BeforeEach
    void setUp() throws NullValueException {
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
        Calendar birthdate = new GregorianCalendar(2018,10,25);
        assertEquals(birthdate.get(Calendar.YEAR),pet.getBirthdate().get(Calendar.YEAR));
        assertEquals(birthdate.get(Calendar.MONTH),pet.getBirthdate().get(Calendar.MONTH));
        assertEquals(birthdate.get(Calendar.DAY_OF_MONTH),pet.getBirthdate().get(Calendar.DAY_OF_MONTH));
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
    void setName() throws NullValueException {
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