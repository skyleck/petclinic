package be.heh.petclinic.web;

import be.heh.petclinic.component.owner.OwnerComponent;
import be.heh.petclinic.component.pet.PetComponent;
import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.domain.Pet;
import be.heh.petclinic.domain.TelephoneNumbeNotValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;

import static javafx.scene.input.KeyCode.T;

@RestController
public class OwnerRestController {

    @Autowired
    OwnerComponent ownerComponentImpl;

    @Autowired
    PetComponent petComponentImpl;

    @CrossOrigin
    @RequestMapping(value = "api/v1/owners", method = RequestMethod.GET)
    public ResponseEntity<Collection<Owner>> getOwners() throws Exception {
        Collection<Pet> pets = petComponentImpl.getPets();
        Collection<Owner> owners = ownerComponentImpl.getOwners(pets);
        if(owners.isEmpty()){
            return new ResponseEntity<Collection<Owner>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Collection<Owner>>(owners,HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "api/v1/addOwner", method = RequestMethod.POST)
    public ResponseEntity<?> addOwner(HttpServletRequest request) throws TelephoneNumbeNotValid {
        String lastname = request.getParameter("lastname");
        String firstname = request.getParameter("firstname");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String telephone = request.getParameter("telephone");

        ownerComponentImpl.addOwner(new Owner(-1,lastname,firstname,address,city,telephone,null));
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value = "api/v1/updateOwner", method = RequestMethod.PUT)
    public ResponseEntity<?>  updateOwner(int id, Owner owner) {
        ownerComponentImpl.updateOwner(id,owner);
        return  new ResponseEntity<String>(HttpStatus.OK);
    }
}
