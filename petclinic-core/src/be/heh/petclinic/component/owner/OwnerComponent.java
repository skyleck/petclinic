package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.domain.Pet;

import java.util.ArrayList;
import java.util.Collection;

public interface OwnerComponent {

    Collection<Owner> getOwner() throws Exception;

    void addOwner(Owner owner);

    void updateOwner(int id, Owner owner);

    void addPetsToOwner(Owner owner, ArrayList<Pet> pets);
    void addPetsToOwner(ArrayList<Owner> owners, ArrayList<Pet> pets);
}
