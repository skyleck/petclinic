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
    public  Owner getOwner(int id,Collection<Pet> pets){
        Owner owner = ownerDao.getOwner(id);
        if(owner != null)
            addPetsToOwner(owner, (ArrayList<Pet>) pets);
        return owner;
    }

    @Override
    public Collection<Owner> getOwners(Collection<Pet> pets){
        Collection<Owner> owners = ownerDao.getOwners();
        addPetsToOwner((ArrayList<Owner>) owners, (ArrayList<Pet>) pets);
        return owners;
    }

    @Override
    public void addOwner(Owner owner) {
        ownerDao.addOwner(owner);
    }

    @Override
    public void updateOwner(int id, Owner owner) {
        ownerDao.updateOwner(id,owner);
    }

    private void addPetsToOwner(Owner owner, ArrayList<Pet> pets){
        for (Pet pet: pets) {
            owner.getPets().add(pet);
        }
    }

    private void  addPetsToOwner(ArrayList<Owner> owners, ArrayList<Pet> pets){
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
