package be.heh.petclinic.component.pet;

import be.heh.petclinic.AbstractComponentTestBase;
import be.heh.petclinic.domain.Pet;
import be.heh.petclinic.domain.TypePet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Calendar;

class JdbcPetDaoTest extends AbstractComponentTestBase {
    private JdbcPetDao jdbcPetDao;
    private JdbcTemplate template;
    private ArrayList<Pet> list;

    @BeforeEach
    public void setUp() {
        DataSource dataSource = (DataSource)applicationContext.getBean("dataSource");
        template = getJdbcTemplate();
        jdbcPetDao = new JdbcPetDao(dataSource);
        list = new ArrayList<Pet>();
        list.add(new Pet(1,"Titi",2015,0,01,TypePet.bird));
        list.add(new Pet(2,"Tardos",2013,11,31,TypePet.dog));
        list.add(new Pet(3,"Buzz",2011,6,15,TypePet.rabbit));
    }

    @Test
    void test() {
        getPets();
        addPet();
        updatePet();
    }

    void getPets() {
        ArrayList<Pet> loadPet = (ArrayList<Pet>)jdbcPetDao.getPets();
        assertEquals(list.size(),loadPet.size());
        System.out.println("ABC : " + list.get(0).getBirthdate().get(Calendar.YEAR) + " : " + loadPet.get(0).getBirthdate().get(Calendar.YEAR));
        System.out.println("MLK : " + list.get(1).getBirthdate().get(Calendar.YEAR) + " : " + loadPet.get(1).getBirthdate().get(Calendar.YEAR));
        System.out.println("MLK : " + list.get(2).getBirthdate().get(Calendar.YEAR) + " : " + loadPet.get(2).getBirthdate().get(Calendar.YEAR));
        assertIterableEquals(list, loadPet);
    }

    void addPet() {
        Pet pet = new Pet(4,"Duck",2001,8,06,TypePet.bird);
        jdbcPetDao.addPet(pet);
        Collection<Pet> loadPet = jdbcPetDao.getPets();
        ArrayList<Pet> test = (ArrayList<Pet>)loadPet;
        assertEquals(pet, test.get(loadPet.size()-1));
    }

    void updatePet() {
        Pet pet = new Pet(4,"Toto",2007,9,07,TypePet.cat);
        this.jdbcPetDao.updatePet(4,pet);
        Collection<Pet> loadPet = jdbcPetDao.getPets();
        ArrayList<Pet> test = (ArrayList<Pet>)loadPet;
        assertEquals(pet, test.get(loadPet.size()-1));
    }
}