package be.heh.petclinic.web;

import be.heh.petclinic.component.Visit.VisitComponent;
import be.heh.petclinic.domain.Visit;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitRestController {
    @Autowired
    VisitComponent visitComp;

    @RequestMapping(value = "api/v1/visits", method = RequestMethod.GET)
    public ResponseEntity<Collection<Visit>> getVisits(){
        Collection<Visit> visits = visitComp.getVisits();
        if(visits.isEmpty()){
            return new ResponseEntity<Collection<Visit>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Collection<Visit>>(visits, HttpStatus.OK);
    }

    @RequestMapping(value = "api/v1/addVisit", method = RequestMethod.POST)
    public ResponseEntity<String> addVisit(Visit v) {
        visitComp.addVisit(v);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value = "api/v1/updateVisit", method = RequestMethod.PUT)
    public ResponseEntity<String> updateVisit(Visit v) {
        visitComp.updateVisit(v);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}