package be.heh.petclinic.web;

import be.heh.petclinic.component.pet.PetComponent;
import be.heh.petclinic.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class PetRestController {
    @Autowired
    PetComponent petComponentImpl;

    @RequestMapping(value = "api/v1/pets", method = RequestMethod.GET)
    public ResponseEntity<Collection<Pet>> getPets(){
        Collection<Pet> pets = petComponentImpl.getPets();
        if(pets.isEmpty()){
            return new ResponseEntity<Collection<Pet>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Collection<Pet>>(pets,HttpStatus.OK);
    }

    @RequestMapping(value = "api/v1/addPet", method = RequestMethod.POST)
    public ResponseEntity<String> addPet(Pet pet) {
        petComponentImpl.addPet(pet);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value = "api/v1/updatePet", method = RequestMethod.PUT)
    public ResponseEntity<String> updatePet(int id, Pet updatePet) {
        int pos = petComponentImpl.searchById(id);
        if(pos != -1) {
            petComponentImpl.updatePet(pos, updatePet);
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        return new ResponseEntity<String>("Pet not found",HttpStatus.NOT_FOUND);
    }
}
