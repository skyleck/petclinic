package be.heh.petclinic.web;

import be.heh.petclinic.component.owner.OwnerComponent;
import be.heh.petclinic.component.pet.PetComponent;
import be.heh.petclinic.domain.Exception.NullValueException;
import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.domain.Pet;
import be.heh.petclinic.domain.Exception.TelephoneNumbeNotValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

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
    public ResponseEntity<?> addOwner(HttpServletRequest request){
        try {
            String lastname = request.getParameter("lastname");
            String firstname = request.getParameter("firstname");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String telephone = request.getParameter("telephone");
            ownerComponentImpl.addOwner(new Owner(-1, lastname, firstname, address, city, telephone, null));
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (TelephoneNumbeNotValid e){
            return new ResponseEntity<String>("TelephoneNumberNotValid",HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NullValueException e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "api/v1/updateOwner", method = RequestMethod.PUT)
    public ResponseEntity<?>  updateOwner(HttpServletRequest request) {
        try {
            int id = Integer.valueOf(request.getParameter("id"));
            String lastname = request.getParameter("lastname");
            String firstname = request.getParameter("firstname");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String telephone = request.getParameter("telephone");
            Owner owner = new Owner(id, lastname, firstname, address, city, telephone, null);
            ownerComponentImpl.updateOwner(id,owner);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (TelephoneNumbeNotValid e){
            return new ResponseEntity<String>("TelephoneNumberNotValid",HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NullValueException e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
