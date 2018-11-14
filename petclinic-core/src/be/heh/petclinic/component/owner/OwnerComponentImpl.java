package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collection;

public class OwnerComponentImpl implements OwnerComponent {

    ArrayList<Owner> owners = new ArrayList<Owner>();

    public OwnerComponentImpl() throws Exception {
        owners.add(new Owner(0,"Hempte","Maxime","18 Rue Du Cirque",
                "Circus","0472854896"));
        owners.add(new Owner(1,"Adrien","Harpignies","7 Rue De La Rue",
                "the city","0478963214"));
    }

    @Override
    public Collection<Owner> getOwner(){
        return owners;
    }

    @Override
    public void addOwner(Owner owner) {
        owners.add(owner);
    }

    public int searchById(int id){
        if(id < owners.size() && owners.get(id).getId() == id){
            return id;
        }
        for(int i = 0; i < owners.size(); i++){
            if(owners.get(i).getId() == id)
                return  i;
        }
        return -1;
    }

    @Override
    public void updateOwner(int id, Owner updateOwner) {
        owners.set(id, updateOwner);
    }
}
