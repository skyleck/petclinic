package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.domain.Pet;

import java.util.ArrayList;
import java.util.Collection;

public interface OwnerComponent {

    Owner getOwner(int id, Collection<Pet> pets);

    Collection<Owner> getOwners(Collection<Pet> pets);

    void addOwner(Owner owner);

    void updateOwner(int id, Owner owner);
}
