package be.heh.petclinic.web;

import be.heh.petclinic.component.owner.OwnerComponent;
import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.domain.TelephoneNumbeNotValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.util.Collection;

import static javafx.scene.input.KeyCode.T;

@RestController
public class OwnerRestController {

    @Autowired
    OwnerComponent ownerComponentImpl;

    @RequestMapping(value = "api/v1/owners", method = RequestMethod.GET)
    public ResponseEntity<Collection<Owner>> getOwners() throws Exception {
        Collection<Owner> owners = ownerComponentImpl.getOwner();
        if(owners.isEmpty()){
            return new ResponseEntity<Collection<Owner>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Collection<Owner>>(owners,HttpStatus.OK);
    }

    @RequestMapping(value = "api/v1/addOwner", method = RequestMethod.POST)
    public ResponseEntity<?> addOwner(Owner owner) throws TelephoneNumbeNotValid {
        ownerComponentImpl.addOwner(owner);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value = "api/v1/updateOwner", method = RequestMethod.PUT)
    public ResponseEntity<?>  updateOwner(int id, Owner updateOwner) {
        int pos = ownerComponentImpl.searchById(id);
        if (pos != -1) {
            ownerComponentImpl.updateOwner(pos, updateOwner);
            return  new ResponseEntity<String>(HttpStatus.OK);
        }
        return  new ResponseEntity<String>("Owner not found",HttpStatus.NOT_FOUND);
    }
}
