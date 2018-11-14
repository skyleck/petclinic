package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;

import java.util.Collection;

public interface OwnerComponent {

    Collection<Owner> getOwner() throws Exception;

    void addOwner(Owner owner);

    void updateOwner(int id, Owner updateOwner);
}
