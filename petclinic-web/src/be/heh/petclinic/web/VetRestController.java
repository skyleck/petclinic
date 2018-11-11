package be.heh.petclinic.web;

import be.heh.petclinic.component.VetComponentImpl;
import be.heh.petclinic.domain.Vet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class VetRestController {

    private VetComponentImpl vetComponent = new VetComponentImpl();

    @RequestMapping("api/v1/vets")
    public List<Vet> getVets(){
        return this.vetComponent.getVets();
    }

}
