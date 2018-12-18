package be.heh.petclinic.component.pet;

import be.heh.petclinic.domain.Pet;
import be.heh.petclinic.domain.TypePet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;

class PetComponentImpl implements PetComponent{
    private JdbcPetDao petDao;

    public PetComponentImpl(DataSource dataSource) {
        petDao = new JdbcPetDao(dataSource);
    }

    @Override
    public Collection<Pet> getPets() {
        return petDao.getPets();
    }

    @Override
    public  Collection<Pet> getPets(int ownerId){
        return petDao.getPets(ownerId);
    }

    @Override
    public void addPet(Pet pet) {
        petDao.addPet(pet);
    }

    @Override
    public void updatePet(int id, Pet updatePet) {
        petDao.updatePet(id, updatePet);
    }

    @Override
    public void deletePet(int id) {
        petDao.deletePet(id);
    }
}
