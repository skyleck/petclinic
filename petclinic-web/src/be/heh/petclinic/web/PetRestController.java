package be.heh.petclinic.web;

import be.heh.petclinic.component.pet.PetComponent;
import be.heh.petclinic.domain.Exception.NullValueException;
import be.heh.petclinic.domain.Pet;
import be.heh.petclinic.domain.TypePet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
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

    @CrossOrigin
    @RequestMapping(value = "api/v1/addPet", method = RequestMethod.POST)
    public ResponseEntity<String> addPet(HttpServletRequest request) {
        try {
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            String[] tab = request.getParameter("birthdateString").split("-");//TODO : Secure input
            String ownerId = request.getParameter("ownerId");
            petComponentImpl.addPet(new Pet(-1, name, Integer.parseInt(tab[0]), Integer.parseInt(tab[1])-1,
                                            Integer.parseInt(tab[2]), Enum.valueOf(TypePet.class,type), Integer.parseInt(ownerId)));

            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (NullValueException e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "api/v1/updatePet", method = RequestMethod.PUT)
    public ResponseEntity<String> updatePet(HttpServletRequest request) {
        try {
            int id = Integer.valueOf(request.getParameter("id"));
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            String[] tab = request.getParameter("birthdateString").split("-");//TODO : Secure input
            String ownerId = request.getParameter("ownerId");
            petComponentImpl.updatePet(id, new Pet(id, name, Integer.parseInt(tab[0]), Integer.parseInt(tab[1])-1,
                                        Integer.parseInt(tab[2]), Enum.valueOf(TypePet.class,type), Integer.parseInt(ownerId)));
        }
        catch (NullValueException e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    
    @CrossOrigin
    @RequestMapping(value = "api/v1/deletePet", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePet(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("idPet"));
        petComponentImpl.deletePet(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
