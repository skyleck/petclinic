package be.heh.petclinic.web;

import be.heh.petclinic.component.owner.OwnerComponent;
import be.heh.petclinic.component.owner.OwnerComponentImpl;
import be.heh.petclinic.domain.Owner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class OwnerRestController {

    OwnerComponentImpl ownerComponent = new OwnerComponentImpl();

    public OwnerRestController() throws Exception {
    }

    @RequestMapping(value = "api/v1/owners", method = RequestMethod.GET)
    public Collection<Owner> getOwners() throws Exception {
        Collection<Owner> owners = ownerComponent.getOwner();
        return owners;
    }

    @RequestMapping(value = "api/v1/addOwner", method = RequestMethod.POST)
    public void addOwner(Owner owner) throws Exception {
        ownerComponent.addOwner(owner);
    }

    @RequestMapping(value = "api/v1/updateOwner", method = RequestMethod.PUT)
    public void updateOwner(int id, Owner updateOwner) {
        int pos = ownerComponent.searchById(id);
        if (pos != -1) {
            ownerComponent.updateOwner(pos, updateOwner);
        }
    }
}
