package be.heh.petclinic.web;

import be.heh.petclinic.component.pet.PetComponentImpl;
import be.heh.petclinic.domain.Pet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class PetRestController {
    PetComponentImpl petComponent = new PetComponentImpl();

    @RequestMapping(value = "api/v1/pets", method = RequestMethod.GET)
    public Collection<Pet> getPets(){
        Collection<Pet> pets = petComponent.getPets();
        return pets;
    }

    @RequestMapping(value = "api/v1/addPet", method = RequestMethod.POST)
    public void addPet(Pet pet) {
        petComponent.addPet(pet);
    }

    @RequestMapping(value = "api/v1/updatePet", method = RequestMethod.PUT)
    public void updatePet(int id, Pet updatePet) {
        int pos = petComponent.searchById(id);
        if(pos != -1) {
            petComponent.updatePet(pos, updatePet);
        }
    }
}
