package be.heh.petclinic.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VetTest {

    Vet vet;

    @BeforeEach
    void initTest(){
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
    void setLastname() {
        this.vet.setLastname("Hempte");
        assertEquals("Hempte",vet.getLastname());
    }

    @Test
    void setFirstname() {
        this.vet.setFirstname("Maxime");
        assertEquals("Maxime", vet.getFirstname());
    }

    @Test
    void setSpeciality() {
        this.vet.setSpeciality("test");
        assertEquals("test",vet.getSpeciality());
    }
}