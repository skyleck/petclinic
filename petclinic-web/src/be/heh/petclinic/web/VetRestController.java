package be.heh.petclinic.web;

import be.heh.petclinic.component.vet.VetComponent;
import be.heh.petclinic.domain.Vet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class VetRestController {

    @Autowired
    private VetComponent vetComponent;

    @RequestMapping("api/v1/vets")
    public List<Vet> getVets(){
        return this.vetComponent.getVets();
    }

}
