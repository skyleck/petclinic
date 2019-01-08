package be.heh.petclinic.domain;

import be.heh.petclinic.domain.Exception.NullValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VetTest {

    Vet vet;

    @BeforeEach
    void initTest() throws NullValueException {
        this.vet = new Vet("James","James","none");
    }

    @Test
    void getLastname() {
        assertEquals("James",vet.getLastname());
    }

    @Test
    void getFirstname() {
        assertEquals("James",vet.getFirstname());
    }

    @Test
    void getSpeciality() {
        assertEquals("none",vet.getSpeciality());
    }

    @Test
    void setLastname() throws NullValueException {
        this.vet.setLastname("Hempte");
        assertEquals("Hempte",vet.getLastname());
    }

    @Test
    void setFirstname() throws NullValueException {
        this.vet.setFirstname("Maxime");
        assertEquals("Maxime", vet.getFirstname());
    }

    @Test
    void setSpeciality() throws NullValueException {
        this.vet.setSpeciality("test");
        assertEquals("test",vet.getSpeciality());
    }
}