package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.domain.Pet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class OwnerComponentImpl implements OwnerComponent {

    private JdbcOwnerDao ownerDao;

    public OwnerComponentImpl(DataSource dataSource){
        ownerDao = new JdbcOwnerDao(dataSource);
    }

    @Override
    public Collection<Owner> getOwner(){
        return ownerDao.getOwners();
    }

    @Override
    public void addOwner(Owner owner) {
        ownerDao.addOwner(owner);
    }

    @Override
    public void updateOwner(int id, Owner owner) {
        ownerDao.updateOwner(id,owner);
    }

    public void addPetsToOwner(Owner owner, ArrayList<Pet> pets){
        for (Pet pet: pets) {
            owner.getPets().add(pet);
        }
    }

    public void  addPetsToOwner(ArrayList<Owner> owners, ArrayList<Pet> pets){
        Iterator iterator = pets.iterator();
        Pet pet = (Pet)iterator.next();
        for (Owner owner: owners) {
            while (pet != null && owner.getId() == pet.getOwnerId()){
                owner.getPets().add(pet);
                if(!iterator.hasNext()){
                    pet = null;
                    continue;
                }
                pet = (Pet)iterator.next();
            }
            if(pet == null)
                break;
        }
    }
}
